package com.example.gestioncontrat.dao.interfaces;

import com.example.gestioncontrat.model.UserActivity;
import java.util.List;

public interface UserActivityInterface {
    void save(UserActivity activity);
    List<UserActivity> findAll();
}
