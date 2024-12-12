package com.example.gestioncontrat.service.interfaces;

public interface UserActivityServiceInterface {
    void logActivity(String username, String action, String endpoint);
    void findAllActivities();
}
