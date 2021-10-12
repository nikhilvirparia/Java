package com.nikhil.dojo_and_ninjas.repositories;

import com.nikhil.dojo_and_ninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long> {

    // This method retrieves all the ninjas from the database
    List<Ninja> findAll();

}
