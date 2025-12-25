package ua.nure.kavresiev.optiview.controller;

import ua.nure.kavresiev.optiview.entity.Admin;
import ua.nure.kavresiev.optiview.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminRepository repository;

    @GetMapping
    public List<Admin> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Admin create(@RequestBody Admin admin) {
        return repository.save(admin);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin details) {
        Admin admin = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));

        admin.setFirstName(details.getFirstName());
        admin.setLastName(details.getLastName());
        admin.setShiftType(details.getShiftType());

        return repository.save(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        repository.deleteById(id);
    }
}