package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    // Save a new registration
    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    // Get all registrations
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    // Update registration status (approved/denied)
    public Registration updateRegistrationStatus(Long id, String status) {
        Optional<Registration> registrationOptional = registrationRepository.findById(id);
        if (registrationOptional.isPresent()) {
            Registration registration = registrationOptional.get();
            registration.setStatus(status);
            return registrationRepository.save(registration);
        }
        return null;
    }
}
