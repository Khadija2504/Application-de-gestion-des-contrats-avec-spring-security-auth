package com.example.gestioncontrat.service.implementations;

import com.example.gestioncontrat.dao.interfaces.UserInterface;
import com.example.gestioncontrat.model.User;
import com.example.gestioncontrat.service.interfaces.UserServiecInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Collections;

@Service("userService")
public class UserService implements UserServiecInterface, UserDetailsService {
    @Autowired
    private UserInterface userDao;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    @Override
    public void register(User user) {
        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email already exists!");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
    @Override
    public boolean checkLogin(String email, String password) {
        System.out.println("Service: Checking login");
        return userDao.checkLogin(email, password);
    }
}
