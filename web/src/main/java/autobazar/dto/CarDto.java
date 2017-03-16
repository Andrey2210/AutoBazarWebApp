package autobazar.dto;

import java.time.LocalDate;

/**
 * Created by Andrey on 13.03.2017.
 */
public class CarDto {
    private String mark;
    private String model;
    private String image;
    private int price;
    private LocalDate year;
    private String transmission;


    public  CarDto() {}

    public CarDto(String mark, String model, String image, int price, LocalDate year, String transmission) {
        this.mark = mark;
        this.model = model;
        this.image = image;
        this.price = price;
        this.year = year;
        this.transmission = transmission;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
