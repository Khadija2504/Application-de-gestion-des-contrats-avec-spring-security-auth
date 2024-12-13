package com.example.gestioncontrat.controller;

import com.example.gestioncontrat.dao.interfaces.UserActivityInterface;
import com.example.gestioncontrat.model.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/activities")
public class UserActivityController {

    private final UserActivityInterface userActivityDAO;

    @Autowired
    public UserActivityController(UserActivityInterface userActivityDAO) {
        this.userActivityDAO = userActivityDAO;
    }

    @GetMapping("/getAllActivities")
    public String getAllActivities(Model model) {
        List<UserActivity> activities = userActivityDAO.findAll();
        model.addAttribute("activities", activities);
        return "master/userActivities";
    }
}
