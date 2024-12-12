package com.example.gestioncontrat.service.implementations;

import com.example.gestioncontrat.dao.interfaces.UserInterface;
import com.example.gestioncontrat.model.Role;
import com.example.gestioncontrat.model.User;
import com.example.gestioncontrat.service.interfaces.UserServiecInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiecInterface {

    @Autowired
    private UserInterface userInterface;

    @Override
    public void save(User user) {
        userInterface.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userInterface.findByEmail(email);
    }

    public User authenticate(String email, String password) {
        Optional<User> userOptional = userInterface.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            System.out.println("Stored password: " + user.getPassword());
            System.out.println("Entered password: " + password);

            if (passwordEncoder.matches(password, user.getPassword())) {
                System.out.println("Password matched!");
                return user;
            } else {
                System.out.println("Password mismatch!");
            }
        }

        System.out.println("User not found or password incorrect");
        return null;
    }

}
