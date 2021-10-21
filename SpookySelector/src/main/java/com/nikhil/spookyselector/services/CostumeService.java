package com.nikhil.spookyselector.services;

import com.nikhil.spookyselector.models.Costume;
import com.nikhil.spookyselector.repositories.CostumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    // Retrieves a Costume
    public Costume findCostume(Long id) {
        Optional<Costume> optionalCostume = costumeRepository.findById(id);
        if (optionalCostume.isPresent()) {
            return optionalCostume.get();
        } else {
            return null;
        }
    }

    // Random a Costume
    public String randomCostume() {
       ArrayList<String> costumeNames = new ArrayList<String>();
        Random rand = new Random();

        costumeNames.add("cat");
        costumeNames.add("clown");
        costumeNames.add("ghost");
        costumeNames.add("mummy");
        costumeNames.add("pirate");
        costumeNames.add("pumpkin");
        costumeNames.add("skeleton");
        costumeNames.add("vampire");
        costumeNames.add("witch");
        costumeNames.add("zombie");

        return costumeNames.get(rand.nextInt(10));

    }

    // Delete a Costume
    public void deleteCostume(Long id) {
        costumeRepository.deleteById((id));
    }

}
