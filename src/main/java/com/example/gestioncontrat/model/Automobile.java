package com.example.gestioncontrat.model;

import com.example.gestioncontrat.enums.AutomobileType;
import com.example.gestioncontrat.enums.History;
import com.example.gestioncontrat.enums.Type;
import com.example.gestioncontrat.enums.UtilisationVehicule;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


import java.util.Date;

@Entity
public class Automobile extends Contract {
    private Date ageConducteur;

    @Enumerated(EnumType.STRING)
    private AutomobileType automobileType;

    @Enumerated(EnumType.STRING)
    private UtilisationVehicule utilisationVehicule;

    @Enumerated(EnumType.STRING)
    private History history;

    public Automobile() {

    }
    public Automobile(int id, Type type, User user, Date ageConducteur, AutomobileType automobileType, UtilisationVehicule utilisationVehicule, History history) {
        super(id, type, user);
        this.ageConducteur = ageConducteur;
        this.automobileType = automobileType;
        this.utilisationVehicule = utilisationVehicule;
        this.history = history;
    }


    public Date getAgeConducteur() {
        return ageConducteur;
    }

    public void setAgeConducteur(Date ageConducteur) {
        this.ageConducteur = ageConducteur;
    }

    public AutomobileType getAutomobileType() {
        return automobileType;
    }

    public void setAutomobileType(AutomobileType automobileType) {
        this.automobileType = automobileType;
    }

    public UtilisationVehicule getUtilisationVehicule() {
        return utilisationVehicule;
    }

    public void setUtilisationVehicule(UtilisationVehicule utilisationVehicule) {
        this.utilisationVehicule = utilisationVehicule;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
