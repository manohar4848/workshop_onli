package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React frontend
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Endpoint for creating a new registration
    @PostMapping
    public ResponseEntity<Registration> register(@RequestBody Registration registration) {
        Registration savedRegistration = registrationService.saveRegistration(registration);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegistration);
    }

    // Endpoint to fetch all registrations
    @GetMapping
    public List<Registration> getRegistrations() {
        return registrationService.getAllRegistrations();
    }

    // Endpoint to update the registration status (approve/deny)
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateStatus(@PathVariable Long id, @RequestBody String status) {
        Registration updatedRegistration = registrationService.updateRegistrationStatus(id, status);
        if (updatedRegistration != null) {
            return ResponseEntity.ok(updatedRegistration);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
