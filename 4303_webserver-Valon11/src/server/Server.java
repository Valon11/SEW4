package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server: gestartet!");

        ExecutorService executorService = Executors.newCachedThreadPool();

        //Server hört auf Port 8080
        try (ServerSocket serverSocket = new ServerSocket(8080)){
            while(true) {
                System.out.println("Server: Höre auf Port 80");
                //Server wartet auf Client-Verbindungen -> blockierend!
                Socket clientSocket = serverSocket.accept();
                System.out.println("Server: Client verbunden");

                //Kommunikation mit Client
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server: Ende");
    }
}
