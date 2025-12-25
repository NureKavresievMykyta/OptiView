package ua.nure.kavresiev.optiview.repository;

import ua.nure.kavresiev.optiview.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}