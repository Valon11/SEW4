package server;

import common.DataTransmitter;
import model.Airplane;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ClientHandler implements Runnable{
    private Socket clientSocket;
    private Collection<Airplane> airplanes;
    private boolean closed = false;

    public ClientHandler(Socket clientSocket, Collection<Airplane> airplanes) {
        this.clientSocket = clientSocket;
        this.airplanes = airplanes;
    }

    @Override
    public void run() {
        try(ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())){
            System.out.println("Warte auf Daten");

            while (closed == false) {
                String msg = (String) in.readObject();
                System.out.println("Nachricht von Client: " + msg);

                if (msg.equals("GETALL")) {
                    new DataTransmitter().send(airplanes, out);
                }

                else if (msg.equals("ADD")){
                    airplanes.add((Airplane) in.readObject());
                    out.writeObject(new String("Flugzeug erfolgreich hinzugefügt!\n"));
                    out.flush();
                }

                else if (msg.contains("DEL")) {
                    String airplaneName = msg.substring(4);

                    Iterator<Airplane> iterator = airplanes.iterator();
                    while (iterator.hasNext()){
                        Airplane airplane = iterator.next();
                        if (airplane.getName().equals(airplaneName)) {
                            iterator.remove();
                            out.writeObject(new String("Flugzeug wurde erfolgreich gelöscht!\n"));
                            out.flush();
                        }
                    }
                }

                else if (msg.contains("GET ")){
                    String airplaneName = msg.substring(4);

                    Iterator<Airplane> iterator = airplanes.iterator();
                    while (iterator.hasNext()){
                        Airplane airplane = iterator.next();
                        if (airplane.getName().equals(airplaneName)) {
                            out.writeObject(airplane);
                            out.flush();
                        }
                    }
                }

                else if (msg.equals("QUIT")) {
                    closed = true;
                }
            }

        } catch (IOException e) {

        } catch (Exception e) {
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
