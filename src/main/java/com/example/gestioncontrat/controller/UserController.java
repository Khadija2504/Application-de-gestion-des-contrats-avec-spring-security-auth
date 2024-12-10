package com.example.gestioncontrat.controller;

import com.example.gestioncontrat.form.LoginForm;
import com.example.gestioncontrat.model.User;
import com.example.gestioncontrat.service.implementations.UserService;
import com.example.gestioncontrat.service.interfaces.UserServiecInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserServiecInterface userService = new UserService();

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email already registered");
            return "auth/register";
        }
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Map<String, Object> model) {
        model.put("loginForm", new LoginForm());
        return "auth/login";
    }

    @PostMapping("/login")
    public String processLogin(@Valid LoginForm loginForm, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            return "auth/login";
        }

        boolean userExists = userService.checkLogin(loginForm.getEmail(), loginForm.getPassword());
        if (userExists) {
            model.put("loginForm", loginForm);
            return "master/home";
        } else {
            result.rejectValue("email", "invaliduser", "Invalid Email or Password!");
            return "auth/login";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "master/home";
    }
}
