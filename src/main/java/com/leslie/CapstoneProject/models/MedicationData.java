/* package com.leslie.CapstoneProject.models;

import java.util.ArrayList;

public class MedicationData {
    static ArrayList<Medication> medications = new ArrayList<>();

    public static ArrayList<Medication> getAll(){
        return medications;
    }
    public static void add(Medication newMedication){
        medications.add(newMedication);
    }
    public static Medication getById(int id){
        Medication theMedication = null;

        for(Medication candidateMedication : medications){
            if(candidateMedication.getMedicationId() == id){
                theMedication = candidateMedication;
            }
        }

        return theMedication;
    }

    public static void remove(int id){
        Medication medicationToRemove = getById(id);
        medications.remove(medicationToRemove);
    }
}

*/