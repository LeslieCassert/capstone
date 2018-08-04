package com.leslie.CapstoneProject.models.data;

import com.leslie.CapstoneProject.models.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface MedicationDAO extends CrudRepository<Medication, Integer> {
}
