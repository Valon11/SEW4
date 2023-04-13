package client;

import common.DataTransmitter;
import model.Airplane;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String incomingMsg = "";
        boolean closed = false;

        try(Socket serverConnection = new Socket("localhost",6400);
            ObjectOutputStream out = new ObjectOutputStream(serverConnection.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(serverConnection.getInputStream())){

            System.out.println("Client: Verbindung hergestellt");

            while (closed == false) {
                System.out.print("Client: Nachricht: ");
                incomingMsg = sc.nextLine();

                // Empfange Daten
                if (incomingMsg.equals("GETALL")) {
                    out.writeObject(new String(incomingMsg));
                    out.flush();
                    Collection<Airplane> airplanes = new DataTransmitter().recieve(in);
                    System.out.println(airplanes +"\n");
                }

                else if (incomingMsg.equals("ADD")){
                    out.writeObject(new String(incomingMsg));

                    System.out.print("Name: " );
                    String name = sc.nextLine();
                    System.out.print("Seats: ");
                    int seats = sc.nextInt();
                    System.out.print("VMax: ");
                    float vMax = sc.nextFloat();
                    System.out.print("Manufacturer: ");
                    String manufacturer = sc.next();
                    System.out.print("Fuel Capacity: ");
                    float fuelCapacity = sc.nextFloat();
                    sc.nextLine();

                    out.writeObject(new Airplane(name, seats, vMax, manufacturer, fuelCapacity));
                    out.flush();
                    String s = (String) in.readObject();
                    System.out.println("Client: Nachricht von Server: "+s);
                }

                else if (incomingMsg.contains("DEL ")) {
                    out.writeObject(new String(incomingMsg));
                    out.flush();
                    String s = (String) in.readObject();
                    System.out.println("Client: Nachricht von Server: "+s);
                }

                else if (incomingMsg.contains("GET ")) {
                    out.writeObject(new String(incomingMsg));
                    out.flush();
                    Airplane airplane = (Airplane) in.readObject();
                    System.out.println("Client: Nachricht von Server: \n"+airplane);
                }

                else if (incomingMsg.equals("QUIT")) {
                    closed = true;
                    serverConnection.close();
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
