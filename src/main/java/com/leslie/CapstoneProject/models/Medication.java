package com.leslie.CapstoneProject.models;


import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
public class Medication {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 100, message = "Please enter the name of the medication.")
    private String name;

    @NotNull
    @Size(min =1, max=10, message = "Please enter the dosage.")
    private String dosage;

    private Time time;

    @ManyToOne
    private Users user;

    @NotNull
    @Size(min=1, max = 10, message="Please enter the number located on the pill. (If it is a vitamin, etc, please enter 'No Number')")
    private String pillNumber;

    private String scriptNumber;
    private String description;
    private String medRestrictions;
    private String dietaryRestrictions;
    private String notes;





    public Medication(String name, String dosage, String pillNumber, String scriptNumber, String description,String medRestrictions, String dietaryRestrictions, String notes, Time time) {

        this.name = name;
        this.dosage = dosage;
        this.time = time;
        this.pillNumber = pillNumber;
        this.scriptNumber = scriptNumber;
        this.description = description;
        this.medRestrictions = medRestrictions;
        this.dietaryRestrictions = dietaryRestrictions;
        this.notes = notes;
    }
    public Medication(){ }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getPillNumber() {
        return pillNumber;
    }

    public void setPillNumber(String pillNumber) {
        this.pillNumber = pillNumber;
    }

    public String getScriptNumber() {
        return scriptNumber;
    }

    public void setScriptNumber(String scriptNumber) {
        this.scriptNumber = scriptNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedRestrictions() {
        return medRestrictions;
    }

    public void setMedRestrictions(String medRestrictions) {
        this.medRestrictions = medRestrictions;
    }

    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

