package com.example.gestioncontrat.model;

import com.example.gestioncontrat.enums.Type;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    private double montant;
    private Date dateDemande;
    private String details;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Devis() {
    }

    public Devis(Type type, double montant, Date dateDemande, String details, User user) {
        this.type = type;
        this.montant = montant;
        this.dateDemande = dateDemande;
        this.details = details;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
