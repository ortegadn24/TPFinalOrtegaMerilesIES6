package edu.ar.listovoy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ar.listovoy.model.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo,Integer> {
    


    
}