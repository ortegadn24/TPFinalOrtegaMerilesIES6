package edu.ar.listovoy.service;


import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Indica a Spring que esta clase es un componente de servicio
@Service
public interface UsuarioService {

     //declaracion de metodos
     //nominativo solo nombre
    public void borrarUsuario(String UsuarioId);
    public void agregarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
     public List <Usuario> listarTodosUsuario();
     public Usuario buscarUnUsuario(Integer UsuarioId);
     public Usuario buscarPorUsuarioIdUsuario(String nombre);
     public Usuario crearNuevoUsuario();

   
}