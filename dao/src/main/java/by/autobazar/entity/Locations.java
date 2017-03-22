package by.autobazar.entity;

/**
 * Created by Andrey on 21.03.2017.
 */
public class Locations implements Entity {
    private long id;
    private String region;
    private String city;

    public Locations() {
    }

    public Locations(long id, String region, String city) {
        this.id = id;
        this.region = region;
        this.city = city;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
