package edu.ar.listovoy.controller;

import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.service.UsuarioService; // 
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Controller

public class UsuarioController {

    private final UsuarioService usuarioService;

    // Inyección de Dependencias por Constructor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // MÉTODOS CRUD (CREATE, READ, UPDATE, DELETE)

    // 1. Mostrar la lista de usuarios activos 
    // GET usuarios     
    @GetMapping("/listarUsuario")
    public String listarUsuariosActivos(Model model) {
        // Obtenemos solo los usuarios activos usando el método del servicio
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarioActivos();

        model.addAttribute("listaUsuario", usuarios); // Usamos "listaUsuarios" para la vista
        return "listaUsuario"; // Retorna el nombre de la vista
    }

    // 2. Muestra el formulario  para registrar un nuevo usuario
    // GET  usuarios nuevo
    @GetMapping("/usuario")
    public String mostrarFormularioRegistro(Model model) {
        // Agregamos un objeto Usuario vacío
        model.addAttribute("usuario", new Usuario());
        // El atributo 'isEdit' puede ser útil para la vista
        model.addAttribute("isEdit", false); 
        return "usuario"; 
    }

    // 3. Guardar nuevo usuario (CREATE)
    // POST usuarios guardar
    @PostMapping("/guardarU")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        // El servicio guardara el objeto enviado desde el formulario(usuario)
        usuarioService.guardaUsuario(usuario);

        // retorna al usuario a la lista principal después de guardar
        return "redirect:/listarUsuario";
    }
    
   
    // 5. MUSTRAR FORMULARIO(usuariohtml) PARA EDITAR (UPDATE - GET)
    // GET usuarios editar por id}
    @GetMapping("/modificarUsuario/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        
        // 1-Obteniene el usuario por ID.
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado para editar con ID: " + id));
        
        // 2-Agrega al usuario encontrado y la bandera de edición
        model.addAttribute("usuario", usuario);
        model.addAttribute("isEdit", true); 
        
        // 3. Reorna la vista del formulario tando en usuariohtml
        return "usuario";
    }

    // 6. ACTUALIZACIÓN (UPDATE - POST)
    // POST usuarios actualizar
    @PostMapping("/actualizarUsuario/{id}")
    public String actualizarUsuario(@PathVariable("id") Integer id, @ModelAttribute Usuario usuarioActualizado) {
        
       
        usuarioActualizado.setUsuarioId(id); 

        //  Llama ala accion de actualización
        Usuario usuarioResultado = usuarioService.actualizarUsuario(id, usuarioActualizado);
        
        // Si la accion devuelve null, se podra mandar el error (opcional)
        if (usuarioResultado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar. Usuario no encontrado con ID: " + id);
        }

        // Retorna a la lista de usuarios 
        return "redirect:/listarUsuario";
    }
    
    // 7. ELIMINAR USUARIO (DELETE - Borrado Lógico)
    // GET usuarios eliminar por id
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuarioLogico(@PathVariable("id") Integer id) {

        boolean eliminado = usuarioService.eliminarUsuarioLogico(id);
        
        // es una opcion  si no se encuentra el ID para eliminar
        if (!eliminado) {
            // Esto es opcion
            System.out.println("Advertencia: Intento de eliminar usuario con ID " + id + " no encontrado.");
        }

        // Redirige al usuario a la listainicial después del ´procesode eliminaacion
        return "redirect:/listarUsuario";
    }
}