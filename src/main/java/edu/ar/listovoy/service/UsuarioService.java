package edu.ar.listovoy.service;


import edu.ar.listovoy.model.Usuario;


import org.springframework.stereotype.Service;
import java.util.List;


// Indica a Spring que esta clase es un componente de servicio
@Service
public interface UsuarioService {

     //declaracion de metodos
     //nominativo solo nombre
    public void borrarUsuario(String UsuarioId) throws Exception;
    public void agregarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
     public List <Usuario> listarTodosUsuario();
     public Usuario buscarUnUsuario(String UsuarioId) throws Exception;;
     public Usuario buscarPorNombreUsuario(String nombre);
     public Usuario crearNuevoUsuario();
     public List<Usuario> listarTodosUsuariosActivos();

   
}