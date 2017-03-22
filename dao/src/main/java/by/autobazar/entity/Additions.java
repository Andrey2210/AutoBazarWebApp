package by.autobazar.entity;

/**
 * Created by Andrey on 21.03.2017.
 */
public class Additions implements Entity {
    private long id;
    private String carColor;
    private String interiorMaterial;
    private String interiorColor;

    public Additions() {
    }

    public Additions(long id, String carColor, String interiorMaterial, String interiorColor) {
        this.id = id;
        this.carColor = carColor;
        this.interiorMaterial = interiorMaterial;
        this.interiorColor = interiorColor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getInteriorMaterial() {
        return interiorMaterial;
    }

    public void setInteriorMaterial(String interiorMaterial) {
        this.interiorMaterial = interiorMaterial;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    @Override
    public long getId() {
        return id;
    }
}
