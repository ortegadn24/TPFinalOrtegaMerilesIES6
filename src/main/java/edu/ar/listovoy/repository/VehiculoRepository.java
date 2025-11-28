package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//jpaRepository... el crud esta dentro del jpa
@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {
    
    List<Vehiculo> findByEstadoVehiculo(Boolean estado);
    /**
     
     * Obtiene una lista de Modelos de Vehiculo cuyo atributo 'estado' es TRUE.
     
     * Estos son los modelos/configuraciones disponibles para la venta.
     
     *  Lista de modelos de Vehiculo activos.
     
     */
    //List<Usuario> findByEstadoVehiculoTrue();

    //void deleteAllById(String VehiculoId);


}