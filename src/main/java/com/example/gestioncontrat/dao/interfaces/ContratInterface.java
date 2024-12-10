package com.example.gestioncontrat.dao.interfaces;

import com.example.gestioncontrat.model.Contract;
import com.example.gestioncontrat.model.Devis;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public interface ContratInterface {

    @Transactional
    void save(Contract contrat);
}
