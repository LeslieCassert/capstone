package com.leslie.CapstoneProject.controllers;


import com.leslie.CapstoneProject.models.Medication;
//import com.leslie.CapstoneProject.models.MedicationData;
import com.leslie.CapstoneProject.models.Time;
import com.leslie.CapstoneProject.models.Users;
import com.leslie.CapstoneProject.models.data.MedicationDAO;
import com.leslie.CapstoneProject.models.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "medication")
public class MedicationController {

    @Autowired
    private MedicationDAO medicationDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "")
    public String landing(Model model){
        model.addAttribute("title", "Welcome to PillPal!");
        return "medication/landing";
    }


    @RequestMapping(value = "home")
    public String index(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")){
            return "redirect:/users/login";
        }
        Users u = userDAO.findByUsername(username).get(0);
        model.addAttribute("medications", u.getMedications());
        model.addAttribute("title", "My Medicines");

        return "medication/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMedicationForm(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")){
            return "redirect:/users/login";
        }

        model.addAttribute("title", "Add Medication");
        model.addAttribute(new Medication());
        model.addAttribute("times", Time.values());

        return "medication/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")){
            return "redirect:users/login";
        }
        Users u = userDAO.findByUsername(username).get(0);
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Medication");
            return "medication/add";
        }
        newMedication.setUser(u);
        medicationDAO.save(newMedication);


        return "redirect:" + newMedication.getId();
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveMedicationForm(Model model, @CookieValue(value = "user", defaultValue = "none") String username) {
        if(username.equals("none")){
            return "redirect:/users/login";
        }
        Users u = userDAO.findByUsername(username).get(0);
        model.addAttribute("medications", u.getMedications());
        model.addAttribute("title", "Remove Medication");
        return "medication/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveMedicationForm(@RequestParam int[] medicationIds) {
        for (int medicationId : medicationIds) {
            medicationDAO.delete(medicationId);

        }
        return "redirect:";
    }

    @RequestMapping(value = "/{medicationId}", method = RequestMethod.GET)
    public String displaySingleMedication(Model model, @PathVariable int medicationId, @CookieValue(value = "user", defaultValue = "none") String username){
        if(username.equals("none")){
            return "redirect:/users/login";
        }
        Users u = userDAO.findByUsername(username).get(0);
        model.addAttribute("medication", medicationDAO.findOne(medicationId));
        return "Medication/medication";
    }
}
