package model;

import java.io.Serializable;

public class Airplane implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int seats;
    private float vMax;
    private String manufacturer;
    private float fuelCapacity;

    public Airplane(String name, int seats, float vMax, String manufacturer, float fuelCapacity) {
        this.name = name;
        this.seats = seats;
        this.vMax = vMax;
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getvMax() {
        return vMax;
    }

    public void setvMax(float vMax) {
        this.vMax = vMax;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                ", vMax=" + vMax +
                ", manufacturer='" + manufacturer + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                '}' +'\n';
    }
}
