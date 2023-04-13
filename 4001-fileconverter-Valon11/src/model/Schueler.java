package model;

import java.io.Serializable;

public class Schueler implements Serializable {
    private int ssd_id;
    private int ssd_katnr;
    private String ssd_zuname;
    private String ssd_vorname;
    private String ssd_geschlecht;
    private String ssd_religion;
    private String ssd_gebdatum;
    private String ssd_str;
    private int ssd_plz;
    private String ssd_ort;
    private String ssd_schulformkurzbez;
    private String ssd_kla_bezeichnung;
    private String ssd_kv;

    public Schueler(int ssd_id, int ssd_katnr, String ssd_zuname, String ssd_vorname, String ssd_geschlecht, String ssd_religion, String ssd_gebdatum, String ssd_str, int ssd_plz, String ssd_ort, String ssd_schulformkurzbez, String ssd_kla_bezeichnung, String ssd_kv) {
        this.ssd_id = ssd_id;
        this.ssd_katnr = ssd_katnr;
        this.ssd_zuname = ssd_zuname;
        this.ssd_vorname = ssd_vorname;
        this.ssd_geschlecht = ssd_geschlecht;
        this.ssd_religion = ssd_religion;
        this.ssd_gebdatum = ssd_gebdatum;
        this.ssd_str = ssd_str;
        this.ssd_plz = ssd_plz;
        this.ssd_ort = ssd_ort;
        this.ssd_schulformkurzbez = ssd_schulformkurzbez;
        this.ssd_kla_bezeichnung = ssd_kla_bezeichnung;
        this.ssd_kv = ssd_kv;
    }

    public int getSsd_id() {
        return ssd_id;
    }

    public void setSsd_id(int ssd_id) {
        this.ssd_id = ssd_id;
    }

    public int getSsd_katnr() {
        return ssd_katnr;
    }

    public void setSsd_katnr(int ssd_katnr) {
        this.ssd_katnr = ssd_katnr;
    }

    public String getSsd_zuname() {
        return ssd_zuname;
    }

    public void setSsd_zuname(String ssd_zuname) {
        this.ssd_zuname = ssd_zuname;
    }

    public String getSsd_vorname() {
        return ssd_vorname;
    }

    public void setSsd_vorname(String ssd_vorname) {
        this.ssd_vorname = ssd_vorname;
    }

    public String getSsd_geschlecht() {
        return ssd_geschlecht;
    }

    public void setSsd_geschlecht(String ssd_geschlecht) {
        this.ssd_geschlecht = ssd_geschlecht;
    }

    public String getSsd_religion() {
        return ssd_religion;
    }

    public void setSsd_religion(String ssd_religion) {
        this.ssd_religion = ssd_religion;
    }

    public String getSsd_gebdatum() {
        return ssd_gebdatum;
    }

    public void setSsd_gebdatum(String ssd_gebdatum) {
        this.ssd_gebdatum = ssd_gebdatum;
    }

    public String getSsd_str() {
        return ssd_str;
    }

    public void setSsd_str(String ssd_str) {
        this.ssd_str = ssd_str;
    }

    public int getSsd_plz() {
        return ssd_plz;
    }

    public void setSsd_plz(int ssd_plz) {
        this.ssd_plz = ssd_plz;
    }

    public String getSsd_ort() {
        return ssd_ort;
    }

    public void setSsd_ort(String ssd_ort) {
        this.ssd_ort = ssd_ort;
    }

    public String getSsd_schulformkurzbez() {
        return ssd_schulformkurzbez;
    }

    public void setSsd_schulformkurzbez(String ssd_schulformkurzbez) {
        this.ssd_schulformkurzbez = ssd_schulformkurzbez;
    }

    public String getSsd_kla_bezeichnung() {
        return ssd_kla_bezeichnung;
    }

    public void setSsd_kla_bezeichnung(String ssd_kla_bezeichnung) {
        this.ssd_kla_bezeichnung = ssd_kla_bezeichnung;
    }

    public String getSsd_kv() {
        return ssd_kv;
    }

    public void setSsd_kv(String ssd_kv) {
        this.ssd_kv = ssd_kv;
    }

    public String toString(String trennzeichen){
        return ssd_id + trennzeichen + ssd_katnr + trennzeichen +
                ssd_zuname + trennzeichen + ssd_vorname + trennzeichen + ssd_geschlecht + trennzeichen +
                ssd_religion + trennzeichen + ssd_gebdatum
                + trennzeichen + ssd_str + trennzeichen + ssd_plz + trennzeichen + ssd_ort + trennzeichen + ssd_schulformkurzbez
                + trennzeichen + ssd_kla_bezeichnung + trennzeichen + ssd_kv;
    }
}
