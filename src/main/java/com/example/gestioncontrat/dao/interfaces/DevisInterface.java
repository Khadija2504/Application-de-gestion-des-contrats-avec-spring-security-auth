package com.example.gestioncontrat.dao.interfaces;

import com.example.gestioncontrat.model.Devis;
import com.example.gestioncontrat.model.User;

import java.util.List;

public interface DevisInterface {
    void save(Devis devis);
    List<Devis> findAll();
    Devis findById(Long id);
    User findUserById(Long userId);
}
