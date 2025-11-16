package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

    /**
     
     * Obtiene una lista de Modelos de Viajes cuyo atributo 'estado' es TRUE.
     
     * Estos son los modelos/configuraciones disponibles para la venta.
     
     *  Lista de modelos de viajes activos.
     
     */
    List<Viaje> findByEstadoViajeTrue();
    
    
}