package by.autobazar.entity;

/**
 * Created by Andrey on 21.03.2017.
 */
public class Characteristics implements Entity {
    private long id;
    private int doorsNumber;
    private String fuelType;
    private double engineCapacity;
    private String driving;

    public Characteristics() {
    }

    public Characteristics(long id, int doorsNumber, String fuelType, double engineCapacity, String driving) {
        this.id = id;
        this.doorsNumber = doorsNumber;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.driving = driving;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getDriving() {
        return driving;
    }

    public void setDriving(String driving) {
        this.driving = driving;
    }
}
