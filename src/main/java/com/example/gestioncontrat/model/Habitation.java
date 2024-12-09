package com.example.gestioncontrat.model;

import com.example.gestioncontrat.enums.Type;
import jakarta.persistence.Entity;

@Entity
public class Habitation extends Contract {
    private double valeurBien;
    private String typeLogement;
    private String localisation;

    public Habitation(int id, Type type, User user, double valeurBien, String typeLogement, String localisation) {
        super(id, type, user);
        this.valeurBien = valeurBien;
        this.typeLogement = typeLogement;
        this.localisation = localisation;
    }

    public Habitation() {

    }

    public double getValeurBien() {
        return valeurBien;
    }

    public void setValeurBien(double valeurBien) {
        this.valeurBien = valeurBien;
    }

    public String getTypeLogement() {
        return typeLogement;
    }

    public void setTypeLogement(String typeLogement) {
        this.typeLogement = typeLogement;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
