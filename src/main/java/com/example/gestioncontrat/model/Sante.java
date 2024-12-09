package com.example.gestioncontrat.model;

import com.example.gestioncontrat.enums.Type;
import com.example.gestioncontrat.enums.TypeCouverture;
import jakarta.persistence.Entity;

@Entity
public class Sante extends Contract {
    private int age;
    private String etatSante;
    private TypeCouverture typeCouverture;

    public Sante(int id, Type type, User user, int age, String etatSante, TypeCouverture typeCouverture) {
        super(id, type, user);
        this.age = age;
        this.etatSante = etatSante;
        this.typeCouverture = typeCouverture;
    }

    public Sante() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEtatSante() {
        return etatSante;
    }

    public void setEtatSante(String etatSante) {
        this.etatSante = etatSante;
    }

    public TypeCouverture getTypeCouverture() {
        return typeCouverture;
    }

    public void setTypeCouverture(TypeCouverture typeCouverture) {
        this.typeCouverture = typeCouverture;
    }
}
