package com.ascode.qrcodegenerator.controller;

import com.ascode.qrcodegenerator.domains.Login;
import com.ascode.qrcodegenerator.domains.User;
import com.ascode.qrcodegenerator.services.user.IUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    private final IUserService userService;

    public UserController(final IUserService userService) {
        this.userService = Objects.requireNonNull(userService, "User service in user controller can not be null");
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

    @RequestMapping("/dashboard")
    public ModelAndView getUsersPage() {
        return new ModelAndView("users", "users", userService.getAllUsers());
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user)
    {
        User user1 = userService.createUser(user);
        ModelAndView modelAndView = new ModelAndView();
        if (Objects.isNull(user1)){
            modelAndView.setViewName("error-page");
        } else {
            modelAndView.setViewName("user-data");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
