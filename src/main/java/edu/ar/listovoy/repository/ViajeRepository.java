package edu.ar.listovoy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import edu.ar.listovoy.model.Viaje;

@Repository
public interface ViajeRepository extends CrudRepository<Viaje,Integer> {
    


    
}