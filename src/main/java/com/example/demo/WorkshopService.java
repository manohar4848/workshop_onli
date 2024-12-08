package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    public List<Workshop> getAllWorkshops() {
        return workshopRepository.findAll();
    }

    public Optional<Workshop> getWorkshopById(Long id) {
        return workshopRepository.findById(id);
    }

    public Workshop saveWorkshop(Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    public void deleteWorkshop(Long id) {
        workshopRepository.deleteById(id);
    }
}