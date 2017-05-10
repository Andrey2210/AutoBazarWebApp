package autobazar.utils;

import autobazar.dto.SearchParams;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Andrey
 * Date: 27.04.2017.
 * Time: 15:50
 */
public class CarsUtils {

    private HashMap<String, String> searchPararms;

    public HashMap<String, String> getDefaultSearchParams() {
        searchPararms = new HashMap<>();
        searchPararms.put("minPrice", "0");
        searchPararms.put("maxPrice", "10000000");
        searchPararms.put("minYear", "1960");
        searchPararms.put("maxYear", "2018");
        searchPararms.put("minEngineCapacity", "0");
        searchPararms.put("maxEngineCapacity", "10");
        return searchPararms;
    }

    public HashMap<String, String> getSearchOptions(HttpServletRequest request) {
        Enumeration e = request.getParameterNames();
        searchPararms = getDefaultSearchParams();
        while (e.hasMoreElements()) {
            String q = (String) e.nextElement();
            String str = request.getParameter(q);
            switch (q) {
                case "bodyType":
                case "mark":
                case "model":
                case "transmission":
                case "minPrice":
                case "maxPrice":
                case "minYear":
                case "maxYear":
                case "minEngineCapacity":
                case "maxEngineCapacity":
                    if (!str.equals("")) {
                        searchPararms.put(q, str);
                    }
                    break;
            }
        }
        return searchPararms;
    }

    public void modifySearchOptions(HashMap<String, String> searchPararms, SearchParams newSearchParams) {
        if (newSearchParams.getBodyType() != null) {
            searchPararms.put("bodyType", newSearchParams.getBodyType());
        }
        if (newSearchParams.getMark() != null) {
            if (newSearchParams.getMark().isEmpty()) {
                searchPararms.remove("mark");
            } else {
                searchPararms.put("mark", newSearchParams.getMark());
            }
            if (searchPararms.get("model") != null) {
                searchPararms.remove("model");
            }
        }
        if (newSearchParams.getModel() != null) {
            if (newSearchParams.getModel().isEmpty()) {
                searchPararms.remove("model");
            } else {
                searchPararms.put("model", newSearchParams.getModel());
            }
        }
        if (newSearchParams.getTransmission() != null) {
            searchPararms.put("transmission", newSearchParams.getTransmission());
        }
        if (newSearchParams.getFuelType() != null) {
            searchPararms.put("fuelType", newSearchParams.getFuelType());
        }
        if (newSearchParams.getMinPrice() != 0) {
            searchPararms.put("minPrice", String.valueOf(newSearchParams.getMinPrice()));
        }
        if (newSearchParams.getMaxPrice() != 0) {
            searchPararms.put("maxPrice", String.valueOf(newSearchParams.getMaxPrice()));
        }
        if (newSearchParams.getMinYear() != 0) {
            searchPararms.put("minYear", String.valueOf(newSearchParams.getMinYear()));
        }
        if (newSearchParams.getMaxYear() != 0) {
            searchPararms.put("maxYear", String.valueOf(newSearchParams.getMaxYear()));
        }
        if (newSearchParams.getMinEngineCapacity() != 0) {
            searchPararms.put("minEngineCapacity", String.valueOf(newSearchParams.getMinEngineCapacity()));
        }
        if (newSearchParams.getMaxEngineCapacity() != 0) {
            searchPararms.put("maxEngineCapacity", String.valueOf(newSearchParams.getMaxEngineCapacity()));
        }
    }


}
