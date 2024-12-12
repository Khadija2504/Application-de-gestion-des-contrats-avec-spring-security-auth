package com.example.gestioncontrat.service.interfaces;

import com.example.gestioncontrat.model.Role;

import java.util.Optional;

public interface RoleServiceInterface {
    Optional<Role> findByName(String name);
}
