package common;

import model.Airplane;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

public class DataTransmitter {
    public Collection<Airplane> recieve(ObjectInputStream objectInputStream) throws Exception {
        Collection<Airplane> airplanes = new ArrayList<>();

        try{
            int size = objectInputStream.readInt();
            for (int i = 0; i < size; i++) {
                airplanes.add((Airplane) objectInputStream.readObject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return airplanes;
    }

    public void send(Collection<Airplane> airplanes, ObjectOutputStream objectOutputStream) throws Exception {
        try {
            objectOutputStream.writeInt(airplanes.size());
            for (Airplane airplane : airplanes) {
                objectOutputStream.writeObject(airplane);
            }
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
