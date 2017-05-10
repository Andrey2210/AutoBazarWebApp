package autobazar.dto;

import lombok.Data;

@Data
public class SearchParams {
    private int minPrice;
    private int maxPrice;
    private int minYear;
    private int maxYear;
    private double minEngineCapacity;
    private double maxEngineCapacity;
    private String bodyType;
    private String mark;
    private String model;
    private String transmission;

    public SearchParams() {
    }

}
