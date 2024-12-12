package com.example.gestioncontrat.dao.implementations;

import com.example.gestioncontrat.dao.interfaces.UserInterface;
import com.example.gestioncontrat.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDAO implements UserInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> users = entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        System.out.println("Users found for email " + email + ": " + users.size());
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }
}
