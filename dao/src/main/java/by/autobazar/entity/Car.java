package by.autobazar.entity;

import by.autobazar.entity.carEnum.*;
import by.autobazar.util.LocalDateAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrey
 * Date: 29.03.2017.
 * Time: 2:31
 */
@Entity
@Table(name="T_CAR")
@Data
@ToString(exclude="user")
@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String mark;

    @Column
    private String model;

    @Column
    private int price;

    @Column
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate year;

    @Enumerated(EnumType.STRING)
    @Column
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    @Column(name="F_BODY_TYPE")
    private BodyType bodyType;

    @Column
    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="F_CONDITION")
    private CarCondition carCondition;

    @Column
    private  int milleage;

    @Column(name="F_DOORS_NUMBER")
    private int doorsNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="F_FUEL_TYPE")
    private FuelType fuelType;

    @Column(name="F_ENGINE_CAPACITY")
    private double engineCapacity;

    @Enumerated(EnumType.STRING)
    @Column
    private WheelDriving driving;

    @Enumerated(EnumType.STRING)
    @Column(name="F_CAR_COLOR")
    private CarColor carColor;

    @Enumerated(EnumType.STRING)
    @Column(name="F_INTERIOR_MATERIAL")
    private InteriorMaterial interiorMaterial;

    @Enumerated(EnumType.STRING)
    @Column(name="F_INTERIOR_COLOR")
    private InteriorColor interiorColor;

    @Column
    private String region;

    @Column
    private String city;

    @Column
    private Boolean verified;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="F_USER_ID")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy="car")
    private List<Comment> commentList = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy="car")
    private List<Image> imageList = new ArrayList<>();

    public Car(String mark, String model, int price, LocalDate year, Transmission transmission, BodyType bodyType,
               String description, CarCondition carCondition, int milleage, int doorsNumber,FuelType fuelType,
               double engineCapacity, WheelDriving driving, CarColor carColor, InteriorMaterial interiorMaterial,
               InteriorColor interiorColor, String region, String city, boolean verified) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.year = year;
        this.transmission = transmission;
        this.bodyType = bodyType;
        this.description = description;
        this.carCondition = carCondition;
        this.milleage = milleage;
        this.doorsNumber = doorsNumber;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.driving = driving;
        this.carColor = carColor;
        this.interiorMaterial = interiorMaterial;
        this.interiorColor = interiorColor;
        this.region = region;
        this.city = city;
        this.verified = verified;
    }
}
