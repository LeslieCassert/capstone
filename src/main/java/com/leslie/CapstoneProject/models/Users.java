package com.leslie.CapstoneProject.models;

import java.util.List;

//@Entity
public class Users {

        //@Id
       // @GeneratedValue
        private int id;

        //@NotNull
        //@Size(min=5, max=15)
        private String username;

        //@Email(message = "Email Address is not valid."
        private String email;

        //@NotNull
        //@Size(min=6, message = "Password must contain at least six characters.")
        private String password;

        //@NotNull(message = "Passwords did not match."
        private String confirmPassword;

        //@OneToMany
        //@JoinColumn(name = "user_id")
     //   private List<Medication> medications;

        public Users() {

        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
            verifyPassword();
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            verifyPassword();
        }

        private void verifyPassword(){
            if(password != null && confirmPassword != null && !password.equals(confirmPassword)){
                confirmPassword = null;
            }
        }

       // public List<Medication> getMedications() {return medications;}

    }

