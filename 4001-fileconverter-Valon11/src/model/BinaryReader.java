package model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class BinaryReader implements Reader{
    @Override
    public HashMap<Integer, Schueler> read(String file) throws IOException {
        HashMap<Integer, Schueler> schueler = new HashMap<>();

        int ssd_id;
        int ssd_katnr;
        String ssd_zuname;
        String ssd_vorname;
        String ssd_geschlecht;
        String ssd_religion;
        String ssd_gebdatum;
        String ssd_str;
        int ssd_plz;
        String ssd_ort;
        String ssd_schulformkurzbez;
        String ssd_kla_bezeichnung;
        String ssd_kv;

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
            int i = dis.readInt();
            for (int j = 0; j < i; j++) {
                ssd_id = dis.readInt();
                ssd_katnr = dis.readInt();
                ssd_zuname = dis.readUTF();
                ssd_vorname = dis.readUTF();
                ssd_geschlecht = dis.readUTF();
                ssd_religion = dis.readUTF();
                ssd_gebdatum = dis.readUTF();
                ssd_str = dis.readUTF();
                ssd_plz = dis.readInt();
                ssd_ort = dis.readUTF();
                ssd_schulformkurzbez = dis.readUTF();
                ssd_kla_bezeichnung = dis.readUTF();
                ssd_kv = dis.readUTF();

                schueler.put(ssd_id,new Schueler (ssd_id,ssd_katnr,ssd_zuname,ssd_vorname,ssd_geschlecht,ssd_religion,ssd_gebdatum,ssd_str,ssd_plz,ssd_ort,ssd_schulformkurzbez,ssd_kla_bezeichnung,ssd_kv));
            }
        }
        return schueler;
    }
}
