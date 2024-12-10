package com.example.gestioncontrat.service.implementations;


import com.example.gestioncontrat.dao.implementations.DevisDAO;
import com.example.gestioncontrat.dao.interfaces.DevisInterface;
import com.example.gestioncontrat.enums.Type;
import com.example.gestioncontrat.model.Devis;
import com.example.gestioncontrat.model.User;
import com.example.gestioncontrat.service.interfaces.DevisServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class DevisService implements DevisServiceInterface {

@Override
    public double calculateDevis(Type type, int age, double valeurBien, String typeVehicule,
                                 boolean isProfessionalUse, boolean noClaims, String typeLogement,
                                 boolean isRiskZone, boolean hasSecuritySystem, boolean hasChronicIllness,
                                 String coverageType) {
        double basePrice;
        double montant = 0;

        switch (type) {
            case Automobile:
                basePrice = 500;
                if (age < 25) {
                    basePrice += basePrice * 0.10;
                }
                if ("luxury".equalsIgnoreCase(typeVehicule)) {
                    basePrice += basePrice * 0.15;
                }
                if (isProfessionalUse) {
                    basePrice += basePrice * 0.10;
                }
                if (noClaims) {
                    basePrice -= basePrice * 0.20;
                } else {
                    basePrice += basePrice * 0.10;
                }
                montant = basePrice;
                break;
            case Hbitation:
                basePrice = 300;
                if ("maison".equalsIgnoreCase(typeLogement)) {
                    basePrice += basePrice * 0.02;
                }
                if (isRiskZone) {
                    basePrice += basePrice * 0.05;
                }
                if (valeurBien > 200000) {
                    basePrice += basePrice * 0.10;
                }
                if (hasSecuritySystem) {
                    basePrice -= basePrice * 0.15;
                } else {
                    basePrice += basePrice * 0.15;
                }
                montant = basePrice;
                break;
            case Sante:
                basePrice = 150;
                if (age > 60) {
                    basePrice += basePrice * 0.20;
                }
                if (hasChronicIllness) {
                    basePrice += basePrice * 0.30;
                }
                if ("basic".equalsIgnoreCase(coverageType)) {
                    basePrice -= basePrice * 0.10;
                } else if ("premium".equalsIgnoreCase(coverageType)) {
                    basePrice += basePrice * 0.05;
                }
                montant = basePrice;
                break;
        }
        return montant;
    }
@Override
    public Devis createDevis(User user, Type type, double calculatedAmount, String details) {
        Devis devis = new Devis(type, calculatedAmount, new Date(), details, user);
        return devis;
    }
}
