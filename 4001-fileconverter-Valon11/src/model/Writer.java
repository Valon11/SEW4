package model;

import java.io.IOException;
import java.util.HashMap;

public interface Writer {
    public void write(HashMap<Integer, Schueler> schueler, String file) throws IOException;
}
