package com.leslie.CapstoneProject.models;


import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

//@Entity
public class Medication {


    //   @Id
    //   @GeneratedValue
    //   private int id;

    @NotNull
    @Size(min = 3, max = 100, message = "Please enter the name of the medication.")
    private String name;

    @NotNull
    @Size(min =1, max=10, message = "Please enter the dosage.")
    private String dosage;

    @NotNull
    @Size(min=1, max = 10, message="Please enter the number located on the pill. (If it is a vitamin, etc, please enter 'No Number')")
    private String pillNumber;

    private String scriptNumber;
    private String description;
    private String medRestrictions;
    private String dietaryRestrictions;
    private String notes;
    private int medicationId;
    private static int nextId = 1;

    public Medication(String name, String dosage) {
        this();
        this.name = name;
        this.dosage = dosage;
    }
    public Medication(){
        medicationId = nextId;
        nextId++;
    }
    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
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
}

    // @NotNull
    // @Size(min=1, message = "Description must not be empty")
    // private String description;


    ///  private String pillNumber;

//   private String dietaryRestrictions;

    // private String medRestrictions;

    // private String Notes;

   /* @ManyToOne
    private Locale.Category category;

    @ManyToMany(mappedBy = "medications")
    private List<Menu> menus; */

/*

        public Medication() {
        }

        public int getId () {
            return id;
        }



        public void setDescription(String description) {
            this.description = description;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }
    } */


