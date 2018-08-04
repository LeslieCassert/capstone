package com.leslie.CapstoneProject.controllers;

import com.leslie.CapstoneProject.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UsersController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new Users());
        model.addAttribute("title", "Create Account");
        return "users/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute @Valid Users user,
                      Errors errors) {

        model.addAttribute(user);

        if (!errors.hasErrors()) {
            return "medication/index";
        }

        return "users/add";

    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute(new Users());
        return "users/login";
    }


}
