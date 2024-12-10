package com.example.gestioncontrat.service.interfaces;

import com.example.gestioncontrat.enums.Type;
import com.example.gestioncontrat.model.Devis;
import com.example.gestioncontrat.model.User;

import java.util.List;
import java.util.Map;

public interface DevisServiceInterface {
    double calculateDevis(Type type, int age, double valeurBien, String typeVehicule,
                          boolean isProfessionalUse, boolean noClaims, String typeLogement,
                          boolean isRiskZone, boolean hasSecuritySystem, boolean hasChronicIllness,
                          String coverageType);
    Devis createDevis(User user, Type type, double calculatedAmount, String details);
}
