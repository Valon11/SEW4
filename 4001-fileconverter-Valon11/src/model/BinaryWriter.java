package model;

import java.io.*;
import java.util.HashMap;

public class BinaryWriter implements Writer{

    /*
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
    */

    @Override
    public void write(HashMap<Integer, Schueler> schueler, String file) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            dos.writeInt(schueler.size());

            for (Integer schluessel : schueler.keySet()) {
                dos.writeInt(schueler.get(schluessel).getSsd_id());
                dos.writeInt(schueler.get(schluessel).getSsd_katnr());
                dos.writeUTF(schueler.get(schluessel).getSsd_zuname());
                dos.writeUTF(schueler.get(schluessel).getSsd_vorname());
                dos.writeUTF(schueler.get(schluessel).getSsd_geschlecht());
                dos.writeUTF(schueler.get(schluessel).getSsd_religion());
                dos.writeUTF(schueler.get(schluessel).getSsd_gebdatum());
                dos.writeUTF(schueler.get(schluessel).getSsd_str());
                dos.writeInt(schueler.get(schluessel).getSsd_plz());
                dos.writeUTF(schueler.get(schluessel).getSsd_ort());
                dos.writeUTF(schueler.get(schluessel).getSsd_schulformkurzbez());
                dos.writeUTF(schueler.get(schluessel).getSsd_kla_bezeichnung());
                dos.writeUTF(schueler.get(schluessel).getSsd_kv());
            }
        }
    }
}
