package com.example.gestioncontrat.service;

import com.example.gestioncontrat.enums.Type;
import com.example.gestioncontrat.model.Devis;
import com.example.gestioncontrat.model.User;
import com.example.gestioncontrat.service.implementations.DevisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DevisServiceTest {

    @InjectMocks
    private DevisService devisService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateDevisAutomobile() {
        double result = devisService.calculateDevis(Type.Automobile, 24, 0, "luxury", true, false,
                null, false, false, false, null);
        double expected = 500 * 1.10 * 1.15 * 1.10 * 1.10; // 10% for age, 15% for luxury, 10% for professional, 10% no claims penalty
        assertEquals(expected, result, 0.01);
    }

    @Test
    void testCalculateDevisHabitation() {
        double result = devisService.calculateDevis(Type.Hbitation, 0, 300000, null, false, false,
                "maison", true, true, false, null);
        double expected = 300 * 1.02 * 1.05 * 1.10 * 0.85; // 2% for house, 5% for risk zone, 10% for value > 200,000, -15% for security system
        assertEquals(expected, result, 0.01);
    }

    @Test
    void testCalculateDevisSante() {
        double result = devisService.calculateDevis(Type.Sante, 65, 0, null, false, false,
                null, false, false, true, "premium");
        double expected = 150 * 1.20 * 1.30 * 1.05; // 20% for age > 60, 30% for chronic illness, 5% for premium coverage
        assertEquals(expected, result, 0.01);
    }

    @Test
    void testCreateDevis() {
        User user = new User();
        double calculatedAmount = 600.0;
        String details = "Detailed information about the insurance";

        Devis result = devisService.createDevis(user, Type.Automobile, calculatedAmount, details);

        assertEquals(Type.Automobile, result.getType());
        assertEquals(calculatedAmount, result.getMontant());
        assertEquals(details, result.getDetails());
        assertEquals(user, result.getUser());
        Date now = new Date();
        assertEquals(now.getYear(), result.getDateDemande().getYear());
        assertEquals(now.getMonth(), result.getDateDemande().getMonth());
        assertEquals(now.getDay(), result.getDateDemande().getDay());
    }
}
