package model;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class ObjectStreamWriter implements Writer{
    @Override
    public void write(HashMap<Integer, Schueler> schueler, String file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            oos.writeObject(schueler);
        }
    }
}
