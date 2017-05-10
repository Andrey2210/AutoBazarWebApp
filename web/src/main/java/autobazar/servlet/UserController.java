package autobazar.servlet;


import by.autobazar.entity.Car;
import by.autobazar.entity.User;
import by.autobazar.services.ICarService;
import by.autobazar.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserController {

    private ICarService carService;
    private IUserService userService;

    @Autowired
    public UserController(ICarService carService, IUserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @RequestMapping(value = "/ads", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Car> getProfileAds() {
        User user = userService.findByUserName(getPrincipal());
        return userService.getCarsByUserId(user.getId());
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getProfileSettings() {
        User user = userService.findByUserName(getPrincipal());
        return user;
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
