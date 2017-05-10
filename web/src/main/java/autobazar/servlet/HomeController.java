package autobazar.servlet;

import autobazar.utils.CarsUtils;
import autobazar.dto.PageDetailsDto;
import by.autobazar.entity.Car;
import by.autobazar.entity.Image;
import by.autobazar.entity.User;
import by.autobazar.services.ICarService;
import by.autobazar.services.IUserService;
import by.autobazar.services.ServiceException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    private ICarService carService;
    private IUserService userService;
    private CarsUtils carsUtils = new CarsUtils();

    @Autowired
    public HomeController(ICarService carService, IUserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @RequestMapping(value = {"/access_denied"})
    public String deniedAccessPage(@RequestParam(name = "error") String error, ModelMap modelMap) {
        switch (error) {
            case "authError":
                modelMap.put("authError", "authenticationError");
            case "accessError":
                modelMap.put("accessError", "accessError");
        }
        return "home";
    }

    @GetMapping(value = {"/home"})
    public String homePage(ModelMap modelMap) {
        List<Car> carsList = carService.getLimitAmount();
        modelMap.addAttribute("list", carsList);
        modelMap.addAttribute("allMakes", carService.getCarsMakes());
        return "home";
    }

    @GetMapping(value = {"/login"})
    public String loginPage(ModelMap modelMap) {
        return "login";
    }

    @GetMapping(value = {"/logout"})
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/home";
    }

    @GetMapping(value = {"/registration"})
    public String registrationPage(ModelMap modelMap) {
        return "registration";
    }

    @RequestMapping(value = {"/cars"}, method = RequestMethod.POST)
    public String carsPage(ModelMap modelMap, HttpServletRequest request) {
        PageDetailsDto pageDetails = new PageDetailsDto(carService.getAmountOfCars(carsUtils.getSearchOptions(request)));
        pageDetails.setSearchParameters(carsUtils.getSearchOptions(request));
        List<Car> carList = carService.searchCars(pageDetails.getSearchParameters(), pageDetails.getSort(),
                (pageDetails.getPageNumber() - 1) * pageDetails.getItemsOnPage(), pageDetails.getItemsOnPage());
        request.getSession().setAttribute("pageDetails", pageDetails);
        request.setAttribute("list", carList);
        request.setAttribute("allMakes", carService.getCarsMakes());
        return "cars";
    }

    @RequestMapping(value = {"/cars"}, method = RequestMethod.GET)
    public String searchCarsPage(ModelMap modelMap, HttpServletRequest request) {
        List<Car> carList = carService.getAll();
        PageDetailsDto pageDetails = new PageDetailsDto(carList.size());
        pageDetails.setSearchParameters(carsUtils.getDefaultSearchParams());
        request.getSession().setAttribute("pageDetails", pageDetails);
        request.setAttribute("list", carList);
        request.setAttribute("allMakes", carService.getCarsMakes());
        return "cars";
    }

    @GetMapping(value = {"/dashboard"})
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAll());
        return "dashboard";
    }

    @GetMapping(value = {"/submit"})
    public String submitPage(ModelMap modelMap) {
        modelMap.addAttribute("allMakes", carService.getAllCarsMakes());
        modelMap.addAttribute("car", new Car());
        return "submit";
    }

    @GetMapping(value = {"/profile"})
    public String profilePage(ModelMap modelMap) {
        User user = userService.findByUserName(getPrincipal());
        modelMap.addAttribute("user", carService.getAllCarsMakes());
        modelMap.addAttribute("list", userService.getCarsByUserId(user.getId()));
        return "accountInfo";
    }

    @PostMapping(value = {"/submit"})
    public String submitPage(@ModelAttribute MultipartFile img, @Valid Car car, HttpServletRequest request) {
        try {
            validateImage(img);
            Random random = new Random();
            int randomValue = random.nextInt();
            String path = request.getSession().getServletContext().getRealPath(File.separator + "media" + File.separator +
                    "237x202" + File.separator + randomValue + img.getName() + ".jpg");
            String bdPath = "media/237x202/" + randomValue + img.getName() + ".jpg";
            saveImage(img, path);
            Image image = new Image(bdPath, "main");
            image.setCar(car);
            car.getImageList().add(image);
            User user = userService.findByUserName(getPrincipal());
            car.setUser(user);
            carService.saveOrUpdate(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/home";

    }

    private void validateImage(MultipartFile image) throws IOException {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new IOException("Only jpeg images accepted");
        }
    }

    private void saveImage(MultipartFile image, String path) throws IOException {
        File file = new File(path);
        FileUtils.writeByteArrayToFile(file, image.getBytes());
    }

    @PostMapping(value = {"/registration"})
    public String userRegistration(@RequestParam(name = "confirmPassword") String confirmPassword,
                                   ModelMap modelMap, @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (userService.findByUserName(user.getLogin()) != null) {
            modelMap.addAttribute("lastAction", "registration.login.inUse");
            return "registration";
        }
        if (userService.getByEmail(user.getEmail()) != null) {
            modelMap.addAttribute("lastAction", "registration.email.inUse");
            return "registration";
        }
        if (!user.getPassword().equals(confirmPassword)) {
            modelMap.addAttribute("lastAction", "registration.notIdenticalPasswords");
            return "registration";
        }
        try {
            userService.createUser(user);
            modelMap.addAttribute("lastAction", "registration.success");
            return "home";
        } catch (ServiceException e) {
            modelMap.addAttribute("lastAction", "registration.notSuccess");
            return "registration";
        }
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

    @RequestMapping(value = {"/cars/{id}"}, method = RequestMethod.GET)
    public String searchCarsPage(@PathVariable("id") Long id, ModelMap modelMap, HttpServletRequest request) {
        Car car = carService.getCarById(id);
        List<Car> carsList = carService.getLimitAmount();
        modelMap.addAttribute("list", carsList);
        modelMap.addAttribute("car", car);
        modelMap.addAttribute("commentsList", car.getCommentList());
        return "detail";
    }

    @PostMapping(value = {"/profile/settings/{id}"})
    public String updateUser(ModelMap modelMap, @Valid User user, BindingResult bindingResult) {
        try {
            userService.updateUser(user);
            modelMap.addAttribute("lastAction", "registration.success");
            return "redirect:/profile";
        } catch (ServiceException e) {
            return "redirect:/profile";
        }
    }

    @RequestMapping(value = {"/cars/{id}"}, method = RequestMethod.POST)
    public String searchCarsPage(@PathVariable("id") Long id, @ModelAttribute MultipartFile img,
                                 @Valid Car newCar, HttpServletRequest request) {
        Car car = carService.get(id);
        try {
            if (img != null) {
                validateImage(img);
                Random random = new Random();
                int randomValue = random.nextInt();
                String path = request.getSession().getServletContext().getRealPath(File.separator + "media" + File.separator +
                        "237x202" + File.separator + randomValue + img.getName() + ".jpg");
                String bdPath = "media/237x202/" + randomValue + img.getName() + ".jpg";
                car.getImageList().get(0).setImagePath(bdPath);
            }
            car.setPrice(newCar.getPrice());
            car.setYear(String.valueOf(newCar.getYear().getYear()));
            car.setTransmission(newCar.getTransmission());
            car.setBodyType(newCar.getBodyType());
            car.setDescription(newCar.getDescription());
            car.setCarCondition(newCar.getCarCondition());
            car.setMilleage(newCar.getMilleage());
            car.setDoorsNumber(newCar.getDoorsNumber());
            car.setFuelType(newCar.getFuelType());
            car.setEngineCapacity(newCar.getEngineCapacity());
            car.setDriving(newCar.getDriving());
            car.setCarColor(newCar.getCarColor());
            car.setInteriorMaterial(newCar.getInteriorMaterial());
            car.setInteriorColor(newCar.getInteriorColor());
            car.setRegion(newCar.getRegion());
            car.setCity(newCar.getCity());
            car.setVerified(false);
            carService.saveOrUpdate(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/profile";
    }

    @RequestMapping(value = {"/cars/edit/{id}"}, method = RequestMethod.GET)
    public String editCarPage(@PathVariable("id") Long id, ModelMap modelMap) {
        Car car = carService.getCarById(id);
        modelMap.addAttribute("car", car);
        return "updateCar";
    }

    @RequestMapping(value = "/profile/cars/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable Long id) {
        Car car = carService.get(id);
        long userId = car.getUser().getId();
        carService.delete(car);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/admin/cars/{id}", method = RequestMethod.GET)
    public String delCar(@PathVariable Long id) {
        Car car = carService.get(id);
        long userId = car.getUser().getId();
        carService.delete(car);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/admin/users/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable Long id) {
        User user = userService.get(id);
        userService.delete(user);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/admin/checkCar/{id}", method = RequestMethod.GET)
    public String checkCar(@PathVariable Long id) {
        carService.verifiedCar(id, "true");
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/admin/uncheckCar/{id}", method = RequestMethod.GET)
    public String uncheckCar(@PathVariable Long id) {
        carService.verifiedCar(id, "false");
        return "redirect:/dashboard";
    }
}