package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Conductor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//jpaRepository... el crud esta dentro del jpa
@Repository
public interface ConductorRepository extends CrudRepository<Conductor, Integer> {
    
    List<Conductor> findByEstadoConductor(Boolean estado);
    /**
     
     * Obtiene una lista de Modelos de Conductor cuyo atributo 'estado' es TRUE.
     
     * Estos son los Conductor/configuraciones disponibles para la venta.
     
     *  Lista de modelos de usuarios activos.
     
     */
    //List<Usuario> findByEstadoConductorTrue();

    //void deleteAllById(String conductorId);


} 