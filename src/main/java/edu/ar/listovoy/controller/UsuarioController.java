package edu.ar.listovoy.controller;

import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.service.UsuarioService; // Asegúrate de que este sea el Service con los 5 métodos
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Controller
//@RequestMapping("/usuario") // Prefijo para todas las rutas del controlador (opcional pero recomendado)
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Inyección de Dependencias por Constructor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // --- MÉTODOS CRUD (CREATE, READ, UPDATE, DELETE) ---

    // 1. Mostrar la lista de usuarios activos (READ ALL - Vista Principal)
    // GET /usuarios/
    @GetMapping("/listarUsuario")
    public String listarUsuariosActivos(Model model) {
        // Obtenemos solo los usuarios activos usando el método del servicio
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarioActivos();

        model.addAttribute("listaUsuario", usuarios); // Usamos "listaUsuarios" para la vista
        return "listaUsuario"; // Retorna el nombre de la plantilla HTML
    }

    // 2. Mostrar el formulario para registrar un nuevo usuario
    // GET /usuarios/nuevo
    @GetMapping("/usuario")
    public String mostrarFormularioRegistro(Model model) {
        // Agregamos un objeto Usuario vacío
        model.addAttribute("usuario", new Usuario());
        // El atributo 'isEdit' puede ser útil para la vista
        model.addAttribute("isEdit", false); 
        return "usuario"; // Vista HTML del formulario
    }

    // 3. Guardar nuevo usuario (CREATE)
    // POST /usuarios/guardar
    @PostMapping("/guardarU")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        // El servicio guarda el objeto enviado desde el formulario
        usuarioService.guardaUsuario(usuario);

        // Redirige al usuario a la lista principal después de guardar
        return "redirect:/listarUsuario";
    }
    
    // 4. VER DETALLE DEL USUARIO (READ By ID)
    // GET /usuarios/detalle/{id}
    //@GetMapping("/detalle/{id}")
    //public String verDetalleUsuario(@PathVariable("id") Integer id, Model model) {

        // Usa el Optional<Usuario> del servicio y lanza 404 si no existe
        //Usuario usuario = usuarioService.obtenerUsuarioPorId(id)
                //.orElseThrow(
                       // () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado con ID: " + id));

       // model.addAttribute("usuario", usuario);
       // return "detalleUsuario"; // Retorna la plantilla de detalle
    //}
    
    // 5. MOSTRAR FORMULARIO PARA EDITAR (UPDATE - GET)
    // GET /usuarios/editar/{id}
    @GetMapping("/modificarUsuario/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        
        // 1. Obtener el usuario por ID, lanzando 404 si no existe
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado para editar con ID: " + id));
        
        // 2. Agregar el usuario encontrado y la bandera de edición
        model.addAttribute("usuario", usuario);
        model.addAttribute("isEdit", true); 
        
        // 3. Reutilizar la vista del formulario
        return "usuario";
    }

    // 6. PROCESAR ACTUALIZACIÓN (UPDATE - POST)
    // POST /usuarios/actualizar/{id}
    @PostMapping("/actualizarUsuario/{id}")
    public String actualizarUsuario(@PathVariable("id") Integer id, @ModelAttribute Usuario usuarioActualizado) {
        
        // 1. Establecer el ID en el objeto recibido del formulario
        // Asumiendo que el ID del modelo Usuario es 'usuarioId' (adaptar si es diferente)
        usuarioActualizado.setUsuarioId(id); 

        // 2. Llamar al servicio de actualización
        Usuario usuarioResultado = usuarioService.actualizarUsuario(id, usuarioActualizado);
        
        // Si el servicio devuelve null, se podría manejar el error (opcional)
        if (usuarioResultado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar. Usuario no encontrado con ID: " + id);
        }

        // 3. Redirigir a la lista de usuarios
        return "redirect:/listarUsuario";
    }
    
    // 7. ELIMINAR USUARIO (DELETE - Borrado Lógico)
    // GET /usuarios/eliminar/{id}
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuarioLogico(@PathVariable("id") Integer id) {

        boolean eliminado = usuarioService.eliminarUsuarioLogico(id);
        
        // Opcional: Manejar si no se encuentra el ID para eliminar
        if (!eliminado) {
            // Esto es opcional, ya que solo redirigirá, pero es buena práctica saber si funcionó
            System.out.println("Advertencia: Intento de eliminar usuario con ID " + id + " no encontrado.");
        }

        // Redirige al usuario a la lista principal después de la operación
        return "redirect:/listarUsuario";
    }
}