package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     
     * Obtiene una lista de Modelos de Conductor cuyo atributo 'estado' es TRUE.
     
     * Estos son los modelos/configuraciones disponibles para la venta.
     
     *  Lista de modelos de conductor activos.
     
     */
    List<Usuario> findByEstadoUsuarioTrue();


} 