package edu.ar.listovoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.repository.UsuarioRepository;

@Service

@Qualifier("servicioUsuarioMySQL")
public class UsuarioServiceImpBD implements UsuarioService {

     @Autowired
    Usuario nuevoUsuario; //estamos inyectando la dependencia Usuario que se llama NuevoUsuario
       //va a cuenta de   Usuario nuevoUsuario = new Usuario();
    @Autowired
     UsuarioRepository usuarioRepository; //usamos esto xq ahi mucha interaccion con el sistema y para no sobre cargar la memoria.

    @Override
    public void borrarUsuario(String usuarioId) throws Exception {       
        Usuario usuarioBorrar = usuarioRepository.findById(usuarioId).orElseThrow(()-> new Exception("usuario no encontrado"));
        usuarioBorrar.setEstadoUsuario(false);   //gral: entro ,lo busco, se  le asigno a borrar
        usuarioRepository.save(usuarioBorrar);                  //g: en borrado le cambio el estado y luego lo guardo.
        //usuarioRepository.deleteAllById(UsuarioId); //le esta mandando al reposotory borrar de la lista
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuario.setEstadoUsuario(true);
       usuarioRepository.save(usuario);
       
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
     
        throw new UnsupportedOperationException("Unimplemented method 'modificarUsuario'");
    }

    @Override
    public List<Usuario> listarTodosUsuario() {
        return (List<Usuario>) usuarioRepository.findAll(); //iterable((es mas sofisticado p resolv errores)) y el List son similares . entre() hace el casteo o casqueo "latransformacion de un tipo de dato a otro"
        
    }

    @Override
    public Usuario buscarUnUsuario(String usuarioId) throws Exception {
      
       return usuarioRepository.findById(usuarioId).orElseThrow(()-> new Exception("usuario no encontrado"));
    }

    @Override
    public Usuario buscarPorNombreUsuario(String nombre) {
       
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorUsuarioIdUsuario'");
    }

    @Override
    public Usuario crearNuevoUsuario() {
        return nuevoUsuario;
    }

    

    @Override
    public List<Usuario> listarTodosUsuariosActivos() {
       return usuarioRepository.finByUsuarioEstado(true);
        
    }


    
} 
    
