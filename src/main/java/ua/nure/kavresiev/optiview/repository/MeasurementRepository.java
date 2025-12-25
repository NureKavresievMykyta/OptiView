package ua.nure.kavresiev.optiview.repository;

import ua.nure.kavresiev.optiview.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByMedicalRecordId(Long medicalRecordId);
}