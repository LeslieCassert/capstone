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
    //medications = dao.findall()

    public static ArrayList<Medication> findByValue(String value) {
        System.out.println("hit me");
        System.out.println(medications);

        ArrayList<Medication> matchingMedications = new ArrayList<>();

        for (Medication medication : medications) {

            System.out.println("inside the for loop");

            if (medication.getName().toLowerCase().contains(value)) {
                matchingMedications.add(medication);
            }
            else {
                System.out.println("poop");
            }
        }

        return matchingMedications;
    }
}
