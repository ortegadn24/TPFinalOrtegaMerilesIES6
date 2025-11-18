package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    /**
     
     * Obtiene una lista de Modelos de Vehiculos cuyo atributo 'estado' es TRUE.
     
     * Estos son los modelos/configuraciones disponibles para la venta.
     
     *  Lista de modelos de vehiculos activos.
     
     */
    List<Vehiculo> findByEstadoVehiculoTrue();
 
    
}