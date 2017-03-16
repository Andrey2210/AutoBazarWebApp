package by.autobazar.entity;


import java.time.LocalDate;

/**
 * Created by Andrey on 21.02.2017.
 */
public class Car implements Entity {
    private long id;
    private String mark;
    private String model;
    private int price;
    private LocalDate year;
    private String transmission;
    private String bodyType;
    private String description;
    private String image;

    public Car(long id, String mark, String model, int price, LocalDate year, String transmission, String bodyType, String description, String image) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.year = year;
        this.transmission = transmission;
        this.bodyType = bodyType;
        this.description = description;
        this.image = image;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
