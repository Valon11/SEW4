package server;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Arrays;

public class ClientHandler implements Runnable{
    private Socket clientSocket;
    private String incomingMsg;
    private String dateiname;
    private String pfad;
    private String status;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        pfad = "www/";
    }

    private void writeFiles(String[] array, BufferedOutputStream outputStream, PrintWriter printWriter, String status) throws IOException {
        String pfadname = ""+pfad+dateiname;
        File file = new File(pfadname);

        if(file.exists()) {
            status = "200 OK";
            printWriter.print("HTTP/1.1 " + status + "\r\n" +
                    "Content-Length: " + file.length() + "\r\n" +
                    "Content-Type: " + Files.probeContentType(file.toPath()) + "\r\n"+"\r\n");

            System.out.println("\n"+"HTTP/1.1 " + status + "\r\n" +
                    "Content-Length: " + file.length() + "\r\n" +
                    "Content-Type: " + Files.probeContentType(file.toPath()) + "\r\n\r\n");

            printWriter.flush();

            outputStream.write(Files.readAllBytes(file.toPath()));
            outputStream.flush();
        }

        else {
            status = "404 Not Found";
            File file404 = new File("www/404.html");
            printWriter.println("HTTP/1.1 " + status + "\r\n" +
                    "Content-Length: " + file404.length() + "\r\n" +
                    "Content-Type: " + Files.probeContentType(file404.toPath()) + "\r\n"+"\r\n");

            System.out.println("\n"+"HTTP/1.1 " + status + "\r\n" +
                    "Content-Length: " + file404.length() + "\r\n" +
                    "Content-Type: " + Files.probeContentType(file404.toPath()) + "\r\n\r\n");

            printWriter.flush();

            outputStream.write(Files.readAllBytes(file404.toPath()));
            outputStream.flush();
        }
    }

    @Override
    public void run() {
        try(BufferedOutputStream outputStream= new BufferedOutputStream(clientSocket.getOutputStream());
            PrintWriter out = new PrintWriter(outputStream);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            System.out.println("Warte auf Daten");

            incomingMsg = in.readLine();
            String s;

            while((s = in.readLine())!=null && s.length()>0){

            }

            String[] input = incomingMsg.split(" ");


            if (input[0].equals("GET") && input[1].contains("/") && input[2].equals("HTTP/1.1")){
                if(input[1].equals("/")) dateiname = "Html.html";
                else dateiname = input[1].substring(1);
                    writeFiles(input, outputStream, out, status);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null)
                    clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}