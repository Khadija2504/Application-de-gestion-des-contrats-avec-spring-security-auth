package com.example.gestioncontrat.dao.interfaces;

import com.example.gestioncontrat.model.Role;

import java.util.Optional;

public interface RoleInterface {
    Optional<Role> findByName(String name);
}
