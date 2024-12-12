package com.example.gestioncontrat.service.implementations;

import com.example.gestioncontrat.dao.interfaces.RoleInterface;
import com.example.gestioncontrat.model.Role;
import com.example.gestioncontrat.service.interfaces.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements RoleServiceInterface {
    @Autowired
    private RoleInterface roleInterface;

    @Override
    public Optional<Role> findByName(String name) {
        return roleInterface.findByName(name);
    }
}
