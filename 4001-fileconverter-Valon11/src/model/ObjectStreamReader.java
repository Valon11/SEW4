package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class ObjectStreamReader implements Reader{
    @Override
    public HashMap<Integer, Schueler> read(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            return (HashMap<Integer, Schueler>) ois.readObject();
        }
    }
}
