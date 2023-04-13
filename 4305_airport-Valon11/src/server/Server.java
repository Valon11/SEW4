package server;

import model.Airplane;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        Collection<Airplane> airplanes = Collections.synchronizedList(new ArrayList<>());
        System.out.println("Server: gestartet!");

        ExecutorService executorService = Executors.newCachedThreadPool();

        airplanes.add(new Airplane("747",300,652.8f,"Boing", 42340));
        airplanes.add(new Airplane("737",220,452.8f,"Boing", 34340));
        airplanes.add(new Airplane("A320",300,752.8f,"Airbus", 76340));

        try (ServerSocket serverSocket = new ServerSocket(6400)){
            while (true) {
                Socket clientConnection = serverSocket.accept();
                System.out.println("Server: Client verbunden");

                // Kommunikation mit Client
                executorService.execute(new ClientHandler(clientConnection, airplanes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
