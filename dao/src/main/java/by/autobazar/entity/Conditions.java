package by.autobazar.entity;

/**
 * Created by Andrey on 21.03.2017.
 */
public class Conditions implements Entity {
    private long id;
    private String carCondition;
    private  int milleage;

    public Conditions() {
    }

    public Conditions(long id, String carCondition, int milleage) {
        this.id = id;
        this.carCondition = carCondition;
        this.milleage = milleage;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(String carCondition) {
        this.carCondition = carCondition;
    }

    public int getMilleage() {
        return milleage;
    }

    public void setMilleage(int milleage) {
        this.milleage = milleage;
    }
}
