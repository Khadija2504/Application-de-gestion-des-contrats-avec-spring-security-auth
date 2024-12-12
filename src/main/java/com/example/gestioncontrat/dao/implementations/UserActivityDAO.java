package com.example.gestioncontrat.dao.implementations;

import com.example.gestioncontrat.dao.interfaces.UserActivityInterface;
import com.example.gestioncontrat.model.UserActivity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserActivityDAO implements UserActivityInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserActivity activity) {
        entityManager.persist(activity);
    }

    @Override
    public List<UserActivity> findAll() {
        return entityManager.createQuery("SELECT a FROM UserActivity a", UserActivity.class)
                .getResultList();
    }
}
