package com.nikhil.dojo_and_ninjas.services;

import com.nikhil.dojo_and_ninjas.models.Dojo;
import com.nikhil.dojo_and_ninjas.models.Ninja;
import com.nikhil.dojo_and_ninjas.repositories.DojoRepository;
import com.nikhil.dojo_and_ninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;
    private final NinjaRepository ninjaRepository;

    public DojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
    }

    // All Dojo
    public List<Dojo> allDojo() {
        return dojoRepository.findAll();
    }

    // One Dojo
    public Dojo getOneDojo (Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

    // Create Dojo
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    // Crete Ninja
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }



}
