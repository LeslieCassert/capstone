package com.leslie.CapstoneProject.controllers;

import com.leslie.CapstoneProject.models.Users;
import com.leslie.CapstoneProject.models.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.Controller;

import javax.validation.Valid;
import java.util.List;

public class UserController {
    @Controller
    @RequestMapping("user")
    public class UserController {

        @Autowired
        private UserDAO.UserDao userdao;

        @RequestMapping(value = "add")
        public String add(Model model) {

            model.addAttribute("title", "User Signup");
            Users user = new Users();
            model.addAttribute("user", user);
            return "user/add";
        }

        @RequestMapping(value = "add", method = RequestMethod.POST)
        public String add(Model model, @ModelAttribute @Valid Users user, Errors errors, String verify) {
            List<Users> sameName = userdao.findByUsername(user.getUsername());
            if(!errors.hasErrors() && user.getPassword().equals(verify) && sameName.isEmpty()) {
                model.addAttribute("user", user);
                userdao.save(user);
                return "user/index";
            } else {
                model.addAttribute("user", user);
                model.addAttribute("title", "User Sign-up");
                if(!user.getPassword().equals(verify)) {
                    model.addAttribute("message", "Passwords do not match.");
                    user.setPassword("");
                }

                if(!sameName.isEmpty()) {
                    model.addAttribute("message", "This username is already in use. Please pick another.");
                }
                return "user/add";
            }
        }

        @RequestMapping(value = "login")
        public String loginForm(Model model) {
            model.addAttribute("title", "Login");
            model.addAttribute(new Users());
            return "user/login";
        }

        @RequestMapping(value = "login", method = RequestMethod.POST)
        public String add(Model model, @ModelAttribute Users user, HttpServletResponse response) {
            List<Users> u = userdao.findByUsername(user.getUsername());
            if(u.isEmpty()) {
                model.addAttribute("message", "Invalid Username");
                model.addAttribute("title", "Login");
                return "user/login";
            }

            SecurityProperties.User loggedIn = u.get(0);
            if(loggedIn.getPassword().equals(user.getPassword())) {

                Cookie c = new Cookie("user", user.getUsername());
                c.setPath("/");
                response.addCookie(c);
                return "redirect:/cheese";
            } else {
                model.addAttribute("message", "Invalid Password");
                model.addAttribute("title", "Login");
                return "user/login";
            }
        }

        @RequestMapping(value = "logout")
        public String logout(HttpServletRequest request, HttpServletResponse response) {
            Cookie[] cookies = request.getCookies();
            if(cookies != null) {
                for (Cookie c : cookies) {
                    c.setMaxAge(0);
                    c.setPath("/");
                    response.addCookie(c);
                }
            }
            return "user/login";
        }
    }
}
