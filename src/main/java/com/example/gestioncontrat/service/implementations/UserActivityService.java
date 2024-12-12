package com.example.gestioncontrat.service.implementations;

import com.example.gestioncontrat.dao.interfaces.UserActivityInterface;
import com.example.gestioncontrat.model.UserActivity;
import com.example.gestioncontrat.service.interfaces.UserActivityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserActivityService implements UserActivityServiceInterface {

    @Autowired
    private UserActivityInterface userActivityDAO;

    @Autowired
    public UserActivityService(UserActivityInterface userActivityDAO) {
        this.userActivityDAO = userActivityDAO;
    }

    @Override
    public void logActivity(String username, String action, String endpoint) {
        UserActivity activity = new UserActivity(username, action, endpoint, LocalDateTime.now());
        userActivityDAO.save(activity);
    }

    @Override
    public void findAllActivities() {
        userActivityDAO.findAll();
    }
}
