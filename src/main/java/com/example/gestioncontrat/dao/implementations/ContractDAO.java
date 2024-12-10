package com.example.gestioncontrat.dao.implementations;

import com.example.gestioncontrat.dao.interfaces.ContratInterface;
import com.example.gestioncontrat.model.Contract;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class ContractDAO implements ContratInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Contract contrat) {
        entityManager.persist(contrat);
    }
}
