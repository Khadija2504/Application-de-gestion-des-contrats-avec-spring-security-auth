package com.example.gestioncontrat.dao.implementations;

import com.example.gestioncontrat.dao.interfaces.AssuranceInterface;
import com.example.gestioncontrat.model.Assurance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AssuranceDAO implements AssuranceInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Assurance assurance) {
        entityManager.persist(assurance);
    }

    @Override
    @Transactional
    public void update(Assurance assurance) {
        entityManager.merge(assurance);
    }
}
