package com.example.gestioncontrat.dao.implementations;

import com.example.gestioncontrat.dao.interfaces.DevisInterface;
import com.example.gestioncontrat.model.Devis;
import com.example.gestioncontrat.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DevisDAO implements DevisInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Devis devis) {
        entityManager.persist(devis);
    }
@Override
    public List<Devis> findAll() {
        return entityManager.createQuery("SELECT d FROM Devis d", Devis.class).getResultList();
    }
@Override
    public Devis findById(Long id) {
        return entityManager.find(Devis.class, id);
    }
    @Override
    public User findUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }
}