package com.example.gestioncontrat.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String action;
    private String endpoint;
    private LocalDateTime timestamp;

    public UserActivity() {}

    public UserActivity(String username, String action, String endpoint, LocalDateTime timestamp) {
        this.username = username;
        this.action = action;
        this.endpoint = endpoint;
        this.timestamp = timestamp;
    }

}
