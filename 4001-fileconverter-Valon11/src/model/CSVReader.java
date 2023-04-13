package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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

public class CSVReader implements Reader {

    private String trennzeichen;

    public CSVReader(String trennzeichen) {
        this.trennzeichen = trennzeichen;
    }

    @Override
        public HashMap<Integer, Schueler> read(String file) throws IOException {
            HashMap<Integer, Schueler> schuelerliste = new HashMap<>();
            String[] data;
            Schueler schueler = null;
            String line = null;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                br.readLine();

                while ((line = br.readLine()) != null) {
                    data = line.split(trennzeichen);

                    schueler = new Schueler(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], data[3], data[4], data[5], data[6], data[7], Integer.parseInt(data[8]), data[9], data[10], data[11], data[12]);

                    schuelerliste.put(Integer.parseInt(data[0]), schueler);
                }

            }
            return schuelerliste;
        }


    }

