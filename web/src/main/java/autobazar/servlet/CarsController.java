package autobazar.servlet;

import autobazar.dto.PageDetailsDto;
import autobazar.dto.SearchParams;
import autobazar.utils.CarsUtils;
import by.autobazar.entity.Car;
import by.autobazar.entity.Image;
import by.autobazar.services.ICarService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private ICarService carService;
    private CarsUtils carsUtils = new CarsUtils();

    @Autowired
    public CarsController(ICarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    @ResponseBody
    public List<Car> searchCars(HttpServletRequest request, ModelMap modelMap,
                                @RequestBody PageDetailsDto newPageDetailes) {
        PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");
        pageDetails.setAmountOfItems(carService.getAmountOfCars(pageDetails.getSearchParameters()));
        if (newPageDetailes.getSort() != null) {
            pageDetails.setSort(newPageDetailes.getSort());
        }
        if (newPageDetailes.getPageNumber() != 0) {
            pageDetails.setPageNumber(newPageDetailes.getPageNumber());
        }
        if (newPageDetailes.getItemsOnPage() != 0) {
            pageDetails.setItemsOnPage(newPageDetailes.getItemsOnPage());
        }
        if (newPageDetailes.getPageType() != null) {
            pageDetails.setPageType(newPageDetailes.getPageType());
        }
        List<Car> carList = carService.searchCars(pageDetails.getSearchParameters(), pageDetails.getSort(),
                (pageDetails.getPageNumber() - 1) * pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage());
        return carList;

    }

    @RequestMapping(value = {"/search/parameters"}, method = RequestMethod.POST)
    @ResponseBody
    public List<Car> searchCars(HttpServletRequest request, ModelMap modelMap,
                                @RequestBody SearchParams searchParams) {
        PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");
        carsUtils.modifySearchOptions(pageDetails.getSearchParameters(), searchParams);
        pageDetails.setAmountOfItems(carService.getAmountOfCars(pageDetails.getSearchParameters()));
        List<Car> carList = carService.searchCars(pageDetails.getSearchParameters(), pageDetails.getSort(),
                (pageDetails.getPageNumber() - 1) * pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage());
        return carList;

    }

    @RequestMapping(value = "/search/{mark}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getByMark(@PathVariable String mark, HttpServletRequest request, ModelMap modelMap) {
        return carService.getCarsModels(mark);
    }

    @RequestMapping(value = "/submit/{mark}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getAllByMark(@PathVariable String mark, HttpServletRequest request, ModelMap modelMap) {
        return carService.getAllCarsModels(mark);
    }




}
