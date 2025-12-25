package ua.nure.kavresiev.optiview.repository;

import ua.nure.kavresiev.optiview.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}