package com.example.gestioncontrat.controller;

import com.example.gestioncontrat.dao.interfaces.UserActivityInterface;
import com.example.gestioncontrat.model.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/activities")
public class UserActivityController {

    private final UserActivityInterface userActivityDAO;

    @Autowired
    public UserActivityController(UserActivityInterface userActivityDAO) {
        this.userActivityDAO = userActivityDAO;
    }

    @GetMapping
    public List<UserActivity> getAllActivities() {
        return userActivityDAO.findAll();
    }
}
