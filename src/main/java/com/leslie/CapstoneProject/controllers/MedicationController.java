package com.leslie.CapstoneProject.controllers;

//import com.leslie.CapstoneProject.models.Medication;
import com.leslie.CapstoneProject.models.Medication;
import com.leslie.CapstoneProject.models.MedicationData;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "medication")
public class MedicationController {


    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("medications", MedicationData.getAll());
        model.addAttribute("title", "My Medicines");

        return "medication/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMedicationForm(Model model) {
        model.addAttribute("title", "Add Medication");
        model.addAttribute(new Medication());

        return "medication/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMedicationForm(@ModelAttribute @Valid Medication newMedication, Errors errors, Model model) {

        if(errors.hasErrors()){
            model.addAttribute("title", "Add Medication");
            return "medication/add";
        }
        MedicationData.add(newMedication);

        return "redirect:medication/" + newMedication.getMedicationId();
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveMedicationForm(Model model) {
        model.addAttribute("medications", MedicationData.getAll());
        model.addAttribute("title", "Remove Medication");
        return "medication/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveMedicationForm(@RequestParam int[] medicationIds) {
        for (int medicationId : medicationIds) {
            MedicationData.remove(medicationId);

        }
        return "redirect:";
    }

    @RequestMapping(value = "medication/{medicationId}", method = RequestMethod.GET)
    public String displaySingleMedication(Model model, @PathVariable int medicationId){
        model.addAttribute("medication", MedicationData.getById(medicationId));
        return "medication/medication";
    }

}
