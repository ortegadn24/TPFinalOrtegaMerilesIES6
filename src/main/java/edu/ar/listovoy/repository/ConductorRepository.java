package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//no son clases son interface..donde tenemos
public interface ConductorRepository extends JpaRepository<Conductor, Integer> {

    /**
     
     * Obtiene una lista de Modelos de Conductores cuyo atributo 'estado' es TRUE.
     
     * Estos son los modelos/configuraciones disponibles para la venta.
     
     *  Lista de modelos de conductores activos.
     
     */
    List<Conductor> findByEstadoConductorTrue();


} 