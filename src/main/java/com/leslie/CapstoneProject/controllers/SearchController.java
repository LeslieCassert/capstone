package com.leslie.CapstoneProject.controllers;


import com.leslie.CapstoneProject.models.Medication;
import com.leslie.CapstoneProject.models.Users;
import com.leslie.CapstoneProject.models.data.MedicationDAO;
import com.leslie.CapstoneProject.models.data.SearchForm;
import com.leslie.CapstoneProject.models.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
@RequestMapping(value="search")
public class SearchController {

    @Autowired
    public MedicationDAO medicationDAO;

    @Autowired
    public UserDAO userDAO;

    @RequestMapping(value="")
    public String searchMedicines(Model model) {
        model.addAttribute("title", "Search Medications");
        model.addAttribute(new SearchForm());
        return "search/index";
    }

    @RequestMapping(value = "results")
    public String searchMedicines(Model model, @ModelAttribute SearchForm searchForm, @CookieValue(value = "user", defaultValue = "none") String username){
        if(username.equals("none")){
            return "redirect:/users/login";
        }
        model.addAttribute("title", "Search Medications");
        Users u = userDAO.findByUsername(username).get(0);
        ArrayList<Medication> medications = (ArrayList<Medication>) medicationDAO.findByUserId(u.getId()); //access to all medications for user

        ArrayList<Medication> matchingMedications = new ArrayList<>();

        for (Medication medication : medications) {

            if (medication.getName().toLowerCase().contains(searchForm.getKeyword())) {
                matchingMedications.add(medication);
            }
        }
        model.addAttribute("medications", matchingMedications);
        return "search/index";
    }



}

