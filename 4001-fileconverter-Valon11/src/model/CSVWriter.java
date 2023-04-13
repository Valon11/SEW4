package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class CSVWriter implements Writer {

    private String trennzeichen;

    public CSVWriter(String trennzeichen) {
        this.trennzeichen = trennzeichen;
    }

    @Override
    public void write(HashMap<Integer, Schueler> schueler, String file) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            printWriter.println("ssd_id" + trennzeichen + "ssd_katnr" + trennzeichen +
                    "ssd_zuname" + trennzeichen + "ssd_vorname" + trennzeichen + "ssd_geschlecht" + trennzeichen +
                    "ssd_religion" + trennzeichen + "ssd_gebdatum"
                    + trennzeichen + "ssd_str" + trennzeichen + "ssd_plz" + trennzeichen + "ssd_ort" + trennzeichen + "ssd_schulformkurzbez"
                    + trennzeichen + "ssd_kla_bezeichnung" + trennzeichen + "ssd_kv_zuname");

            for (int i:schueler.keySet()) {
                Schueler s = schueler.get(i);
                printWriter.println(s.toString(trennzeichen));
            }
        }

    }
}
