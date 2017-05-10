package autobazar.servlet;

import autobazar.dto.PageDetailsDto;
import autobazar.dto.SearchParams;
import autobazar.utils.CarsUtils;
import by.autobazar.entity.Car;
import by.autobazar.entity.Comment;
import by.autobazar.entity.Image;
import by.autobazar.entity.User;
import by.autobazar.services.ICarService;
import by.autobazar.services.ICommentService;
import by.autobazar.services.IUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private ICarService carService;
    private ICommentService commentService;
    private IUserService userService;
    private CarsUtils carsUtils = new CarsUtils();

    @Autowired
    public CarsController(ICarService carService, IUserService userService, ICommentService commentService) {
        this.carService = carService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<Car>> searchCars(HttpServletRequest request, ModelMap modelMap,
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
        if (carList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(carList);

    }

    @RequestMapping(value = {"/search/parameters"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<Car>> searchCarsParameters(HttpServletRequest request, ModelMap modelMap,
                                @RequestBody SearchParams searchParams) {
        PageDetailsDto pageDetails = (PageDetailsDto) request.getSession().getAttribute("pageDetails");
        carsUtils.modifySearchOptions(pageDetails.getSearchParameters(), searchParams);
        pageDetails.setAmountOfItems(carService.getAmountOfCars(pageDetails.getSearchParameters()));
        List<Car> carList = carService.searchCars(pageDetails.getSearchParameters(), pageDetails.getSort(),
                (pageDetails.getPageNumber() - 1) * pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage());
        if (carList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(carList);

    }

    @RequestMapping(value = "/search/{mark}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getByMark(@PathVariable String mark, ModelMap modelMap) {
        return carService.getCarsModels(mark);
    }

    @RequestMapping(value = "/submit/{mark}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getAllByMark(@PathVariable String mark, ModelMap modelMap) {
        return carService.getAllCarsModels(mark);
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Comment> getComments(@PathVariable Long id, ModelMap modelMap) {
        return carService.get(id).getCommentList();
    }

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.POST)
    @ResponseBody
    public List<Comment> createComment(@PathVariable Long id, @RequestBody Comment comment, ModelMap modelMap) {
        User user = userService.findByUserName(getPrincipal());
        Car car = carService.get(id);
        comment.setCar(car);
        comment.setUser(user);
        comment.setCreationsDate(LocalDateTime.now());
        commentService.saveOrUpdate(comment);
        return carService.get(id).getCommentList();
    }

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
