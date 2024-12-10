package com.example.gestioncontrat.controller;

import com.example.gestioncontrat.dao.implementations.ContractDAO;
import com.example.gestioncontrat.dao.implementations.DevisDAO;
import com.example.gestioncontrat.dao.interfaces.ContratInterface;
import com.example.gestioncontrat.dao.interfaces.DevisInterface;
import com.example.gestioncontrat.enums.*;
import com.example.gestioncontrat.model.*;
import com.example.gestioncontrat.service.implementations.DevisService;
import com.example.gestioncontrat.service.interfaces.DevisServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/devis")
public class DevisController {

    @Autowired
    private DevisServiceInterface devisService;

    @Autowired
    private ContratInterface contractDao;

    @Autowired
    private DevisInterface devisDao;


    @PostMapping("/calculate")
    public String requestDevis(
            @RequestParam Type type,
            @RequestParam int age,
            @RequestParam(required = false) Double valeurBien,
            @RequestParam(required = false) String typeVehicule,
            @RequestParam(required = false) Boolean isProfessionalUse,
            @RequestParam(required = false) Boolean noClaims,
            @RequestParam(required = false) String typeLogement,
            @RequestParam(required = false) Boolean isRiskZone,
            @RequestParam(required = false) Boolean hasSecuritySystem,
            @RequestParam(required = false) Boolean hasChronicIllness,
            @RequestParam(required = false) String coverageType,
            @RequestParam Long userId) {

        User user = devisDao.findUserById(userId);
        if (user == null) {
            return "redirect:/error";
        }

        double calculatedAmount = devisService.calculateDevis(type, age, valeurBien, typeVehicule,
                isProfessionalUse, noClaims, typeLogement,
                isRiskZone, hasSecuritySystem,
                hasChronicIllness, coverageType);

        Contract contract;
        switch (type) {
            case Automobile:
                contract = new Automobile();
                ((Automobile) contract).setAgeConducteur(new Date());
                ((Automobile) contract).setAutomobileType(AutomobileType.Modele);
                ((Automobile) contract).setUtilisationVehicule(UtilisationVehicule.Personnel);
                ((Automobile) contract).setHistory(History.Accidents);
                break;
            case Hbitation:
                contract = new Habitation();
                ((Habitation) contract).setValeurBien(valeurBien);
                ((Habitation) contract).setTypeLogement(typeLogement);
                ((Habitation) contract).setLocalisation("Some Location");
                break;
            case Sante:
                contract = new Sante();
                ((Sante) contract).setAge(age);
                ((Sante) contract).setEtatSante("Some Health Status");
                ((Sante) contract).setTypeCouverture(TypeCouverture.Basic);
                break;
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }

        contract.setUser(user);
        contract.setType(type);

        contractDao.save(contract);

        Devis devis = devisService.createDevis(user, type, calculatedAmount, "Details here");
        devisDao.save(devis);

        return "redirect:/home";
    }

    @GetMapping("/form")
    public String showDemandForm(Model model) {
        model.addAttribute("devis", new Devis());
        return "master/devisForm";
    }
}