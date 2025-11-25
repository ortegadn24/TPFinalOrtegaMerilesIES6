package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//jpaRepository... el crud esta dentro del jpa
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    
    List<Usuario> findByEstadoUsuario(Boolean estado);
    /**
     
     * Obtiene una lista de Modelos de Usuarios cuyo atributo 'estado' es TRUE.
     
     * Estos son los modelos/configuraciones disponibles para la venta.
     
     *  Lista de modelos de usuarios activos.
     
     */
    //List<Usuario> findByEstadoUsuarioTrue();

    //void deleteAllById(String usuarioId);


} 