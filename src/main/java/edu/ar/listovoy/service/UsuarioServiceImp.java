package edu.ar.listovoy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Usuario;

@Service
@Qualifier("servicioUsuarioArrayList")
public class UsuarioServiceImp implements UsuarioService {
   
    List<Usuario> listadoDeUsuarios = new ArrayList<Usuario>();
    

    @Autowired
    Usuario nuevoUsuario;

    @Override
    public void borrarUsuario(String UsuarioId) {
       
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        
        listadoDeUsuarios.add(usuario);
        System.out.println(listadoDeUsuarios.size());
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
       
    }

    @Override
    public List<Usuario> listarTodosUsuario() {
        return listadoDeUsuarios;

    }
       

    @Override
    public Usuario buscarUnUsuario(String UsuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombreUsuario'"); 
    }

    @Override
    public Usuario buscarPorNombreUsuario(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombreUsuario'");
    }

    @Override
    public Usuario crearNuevoUsuario() {
      // Usuario nuevoUsuario = new Usuario();
       return nuevoUsuario;
    }

   


    @Override
    public List<Usuario> listarTodosUsuariosActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosUsuariosActivos'");
    }
}


    


    

