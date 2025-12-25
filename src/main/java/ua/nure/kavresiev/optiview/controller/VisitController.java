package ua.nure.kavresiev.optiview.controller;

import ua.nure.kavresiev.optiview.entity.Visit;
import ua.nure.kavresiev.optiview.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @PostMapping
    public Visit createVisit(@RequestBody Visit visit) {
        return visitRepository.save(visit);
    }

    // Отримати візити конкретного пацієнта: /api/visits/patient/5
    @GetMapping("/patient/{patientId}")
    public List<Visit> getVisitsByPatient(@PathVariable Long patientId) {
        return visitRepository.findByPatientId(patientId);
    }

    @PutMapping("/{id}")
    public Visit updateVisit(@PathVariable Long id, @RequestBody Visit details) {
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visit not found with id: " + id));

        visit.setStartTime(details.getStartTime());
        visit.setEndTime(details.getEndTime());
        visit.setVisitStatus(details.getVisitStatus());
        visit.setVisitType(details.getVisitType());
        visit.setDoctorId(details.getDoctorId());
        visit.setPatientId(details.getPatientId());

        return visitRepository.save(visit);
    }

    @DeleteMapping("/{id}")
    public void deleteVisit(@PathVariable Long id) {
        visitRepository.deleteById(id);
    }
}