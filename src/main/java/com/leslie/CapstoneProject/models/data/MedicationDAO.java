package com.leslie.CapstoneProject.models.data;

import com.leslie.CapstoneProject.models.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Repository
@Transactional
public interface MedicationDAO extends CrudRepository<Medication, Integer> {

    //Need a list of all the medications for a certain user "medications"
    public ArrayList<Medication> medications = new ArrayList<>();

    public static ArrayList<Medication> findByValue(String value) {

        ArrayList<Medication> matchingMedications = new ArrayList<>();

        for (Medication medication : medications) {

            if (medication.getName().toLowerCase().contains(value)) {
                matchingMedications.add(medication);
            }
        }

        return matchingMedications;
    }


}
