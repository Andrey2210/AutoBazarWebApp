package autobazar.servlet;

import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.services.ICarService;
import by.autobazar.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private ICarService carService;
    private IUserService userService;

    @Autowired
    public AdminController(ICarService carService, IUserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Car> getCars() {
        return  carService.getAllCars("id", 0, 100);
    }
}
