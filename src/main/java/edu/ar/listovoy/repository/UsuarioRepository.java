package edu.ar.listovoy.repository;


import edu.ar.listovoy.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//jpaRepository... el crud esta dentro del jpa
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    
    List<Usuario> findByEstadoUsuario(Boolean estado);
    
     
 //Obtiene una lista de Modelos de Usuarios cuyo atributo 'estado' es TRUE.
     

} 