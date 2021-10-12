package com.nikhil.dojo_and_ninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.nikhil.dojo_and_ninjas.models.Dojo;
import java.util.List;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
    // This method retrieves all the Pokes from the database
    List<Dojo> findAll();

}
