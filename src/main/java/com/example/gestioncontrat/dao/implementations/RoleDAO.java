package com.example.gestioncontrat.dao.implementations;

import com.example.gestioncontrat.dao.interfaces.RoleInterface;
import com.example.gestioncontrat.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDAO implements RoleInterface {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Optional<Role> findByName(String name) {
        List<Role> roles = entityManager
                .createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class)
                .setParameter("name", name)
                .getResultList();

        return roles.stream().findFirst();
    }

}
