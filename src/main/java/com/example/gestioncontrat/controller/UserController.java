package com.example.gestioncontrat.controller;

import com.example.gestioncontrat.dao.interfaces.RoleInterface;
import com.example.gestioncontrat.model.Role;
import com.example.gestioncontrat.model.User;
import com.example.gestioncontrat.service.interfaces.UserServiecInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/auth")
@Controller
public class UserController {

    @Autowired
    private UserServiecInterface userService;

    @Autowired
    private RoleInterface roleService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login";
    }

    @PostMapping("/perform_login")
    public String performLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        User user = userService.authenticate(email, password);
        System.out.println(email + password);
        if (user != null) {
            System.out.println("user founded");
            session.setAttribute("loggedInUser", user);
            System.out.println("logged in user: " + user);
            return "redirect:/devis/home";
        } else {
            System.out.println("failed to login");
            model.addAttribute("error", "Invalid email or password");
            return "auth/login";
        }
    }

    @GetMapping("/somePage")
    public String accessPage(Model model, Authentication authentication) {
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                System.out.println("Authority: " + authority.getAuthority());
            }
        }
        return "somePage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login?logout";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role defaultRole = roleService.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(defaultRole);

        userService.save(user);
        return "redirect:/auth/login?success";
    }
}
