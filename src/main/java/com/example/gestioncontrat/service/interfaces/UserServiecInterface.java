package com.example.gestioncontrat.service.interfaces;

import com.example.gestioncontrat.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserServiecInterface {
    void register(User user);
    User findByEmail(String email);
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
    boolean checkLogin(String userName, String userPassword);
}