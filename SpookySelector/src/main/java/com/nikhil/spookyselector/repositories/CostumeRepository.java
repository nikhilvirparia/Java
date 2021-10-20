package com.nikhil.spookyselector.repositories;

import com.nikhil.spookyselector.models.Costume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostumeRepository extends CrudRepository <Costume, Long>{

    List<Costume> findAll();

}
