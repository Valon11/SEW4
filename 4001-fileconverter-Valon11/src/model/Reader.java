package model;

import java.io.IOException;
import java.util.HashMap;

public interface Reader {
    public HashMap<Integer, Schueler> read(String file) throws IOException, ClassNotFoundException;
}