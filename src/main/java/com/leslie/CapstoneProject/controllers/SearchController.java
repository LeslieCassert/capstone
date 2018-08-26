package com.leslie.CapstoneProject.controllers;


import com.leslie.CapstoneProject.models.Medication;
import com.leslie.CapstoneProject.models.Users;
import com.leslie.CapstoneProject.models.data.MedicationDAO;
import com.leslie.CapstoneProject.models.data.SearchForm;
import com.leslie.CapstoneProject.models.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String searchMedicines(Model model, @ModelAttribute SearchForm searchForm, String username){
        model.addAttribute("title", "Search Medications");
        ArrayList<Medication> medications;
       // Users u = userDAO.findByUsername(username);
        if (searchForm.getKeyword().equals(MedicationDAO.findByValue(searchForm.getKeyword()))) {
            System.out.println("hit this shit");
            medications = MedicationDAO.findByValue(searchForm.getKeyword());
            model.addAttribute("medications", medications);
        }

        medications = MedicationDAO.findByValue(searchForm.getKeyword());

        model.addAttribute("medications", medications);
        return "search/index";

    }

}

