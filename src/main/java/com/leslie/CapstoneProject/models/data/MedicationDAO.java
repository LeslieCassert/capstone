package com.leslie.CapstoneProject.models.data;

import com.leslie.CapstoneProject.models.Medication;
import com.leslie.CapstoneProject.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public interface MedicationDAO extends CrudRepository<Medication, Integer> {

    //Need a list of all the medications for a certain user "medications"
    public ArrayList<Medication> medications = new ArrayList<>();
    //medications = dao.findall()

    //find by user_id
    List<Medication> findByUserId(int id);

    ArrayList<Medication> findByName(String value);
}
