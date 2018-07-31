package com.leslie.CapstoneProject.models;

import java.util.List;

public class Users {
    //@Entity
    public class User {

        //@Id
       // @GeneratedValue
        private int id;

        //@NotNull
        //@Size(min=5, max=15)
        private String username;

        //@Email
        private String email;

        //@NotNull
        //@Size(min=6)
        private String password;

        //@OneToMany
        //@JoinColumn(name = "user_id")
        private List<Medication> medications;

        public User() {

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
        }

        public List<Medication> getMedications() {return medications;}

    }
}