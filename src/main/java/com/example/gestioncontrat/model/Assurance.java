package com.example.gestioncontrat.model;

import com.example.gestioncontrat.enums.Type;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Type type;

    private double montant;

    private Date dateSouscription;

    @ElementCollection
    private List<String> documentPaths;

    private Integer ageConducteur;
    private Double valeurBien;
    private Boolean isRiskZone;
    private Boolean hasChronicIllness;
    private String typeCouverture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(Date dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public List<String> getDocumentPaths() {
        return documentPaths;
    }

    public void setDocumentPaths(List<String> documentPaths) {
        this.documentPaths = documentPaths;
    }

    public Integer getAgeConducteur() {
        return ageConducteur;
    }

    public void setAgeConducteur(Integer ageConducteur) {
        this.ageConducteur = ageConducteur;
    }

    public Double getValeurBien() {
        return valeurBien;
    }

    public void setValeurBien(Double valeurBien) {
        this.valeurBien = valeurBien;
    }

    public Boolean getIsRiskZone() {
        return isRiskZone;
    }

    public void setIsRiskZone(Boolean isRiskZone) {
        this.isRiskZone = isRiskZone;
    }

    public Boolean getHasChronicIllness() {
        return hasChronicIllness;
    }

    public void setHasChronicIllness(Boolean hasChronicIllness) {
        this.hasChronicIllness = hasChronicIllness;
    }

    public String getTypeCouverture() {
        return typeCouverture;
    }

    public void setTypeCouverture(String typeCouverture) {
        this.typeCouverture = typeCouverture;
    }
}
