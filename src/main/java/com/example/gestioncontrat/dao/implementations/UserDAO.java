package com.example.gestioncontrat.dao.implementations;

import com.example.gestioncontrat.dao.interfaces.UserInterface;
import com.example.gestioncontrat.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements UserInterface {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> users = entityManager
                .createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    public boolean checkLogin(String email, String password) {
        Optional<User> optionalUser = findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user);
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public Optional<User> findByEmail(String email, String password) {
        return Optional.empty();
    }
}
