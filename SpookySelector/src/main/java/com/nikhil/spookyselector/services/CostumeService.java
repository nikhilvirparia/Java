package com.nikhil.spookyselector.services;

import com.nikhil.spookyselector.models.Costume;
import com.nikhil.spookyselector.repositories.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostumeService {

    // Dependency Injection
    private final CostumeRepository costumeRepository;

    @Autowired
    public CostumeService(CostumeRepository costumeRepository) {
        this.costumeRepository = costumeRepository;
    }

    // Return all the Costume
    public List<Costume> allCostume() {
        return costumeRepository.findAll();
    }

    // Delete a Costume
    public void deleteCostume(Long id) {
        costumeRepository.deleteById((id));
    }



}
