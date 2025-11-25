package edu.ar.listovoy.controller;

import edu.ar.listovoy.model.Conductor;
import edu.ar.listovoy.service.ConductorService; // Asegúrate de que este sea el Service con los 5 métodos
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Controller
//@RequestMapping("/conductor") // Prefijo para todas las rutas del controlador (opcional pero recomendado)
public class ConductorController {

    private final ConductorService conductorService;

    // Inyección de Dependencias por Constructor
    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    // --- MÉTODOS CRUD (CREATE, READ, UPDATE, DELETE) ---

    // 1. Mostrar la lista de c activos (READ ALL - Vista Principal)
    // GET /c/
    @GetMapping("/listarConductor")
    public String listarConductoresActivos(Model model) {
        // Obtenemos solo los c activos usando el método del servicio
        List<Conductor> conductores = conductorService.obtenerTodosConductorActivos();

        model.addAttribute("listaConductor", conductores); // Usamos "listaConductor" para la vista
        return "listaConductor"; // Retorna el nombre de la plantilla HTML
    }

    // 2. Mostrar el formulario para registrar un nuevo c
    // GET /conductor/nuevo
    @GetMapping("/conductor")
    public String mostrarFormularioRegistro(Model model) {
        // Agregamos un objeto C vacío
        model.addAttribute("conductor", new Conductor());
        // El atributo 'isEdit' puede ser útil para la vista
        model.addAttribute("isEdit", false); 
        return "conductor"; // Vista HTML de conductor
    }

    // 3. Guardar nuevo conductor (CREATE)
    // POST /conductor/guardar
    @PostMapping("/guardarC")
    public String guardarConductor(@ModelAttribute Conductor conductor) {
        // El servicio guarda el objeto enviado desde el formulario
        conductorService.guardaConductor(conductor);

        // Redirige al c a la lista principal después de guardar
        return "redirect:/listarConductor";
    }
    
    // 4. VER DETALLE DEL conductor (READ By ID)
    // GET /conductores/detalle/{id}
    //@GetMapping("/detalle/{id}")
    //public String verDetalleConductor(@PathVariable("id") Integer id, Model model) {

        // Usa el Optional<Conductor> del servicio y lanza 404 si no existe
        //Conductor conductor = conductorService.obtenerConductorPorId(id)
                //.orElseThrow(
                       // () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado con ID: " + id));

       // model.addAttribute("conductor", conductor);
       // return "detalleConductor"; // Retorna la plantilla de detalle
    //}
    
    // 5. MOSTRAR FORMULARIO PARA EDITAR (UPDATE - GET)
    // GET /conductores/editar/{id}
    @GetMapping("/modificarConductor/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        
        // 1. Obtener el usuario por ID, lanzando 404 si no existe
        Conductor conductor = conductorService.obtenerConductorPorId(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado para editar con ID: " + id));
        
        // 2. Agregar el usuario encontrado y la bandera de edición
        model.addAttribute("conductor", conductor);
        model.addAttribute("isEdit", true); 
        
        // 3. Reutilizar la vista del formulario
        return "conductor";
    }

    // 6. PROCESAR ACTUALIZACIÓN (UPDATE - POST)
    // POST /conductores/actualizar/{id}
    @PostMapping("/actualizarConductor/{id}")
    public String actualizarConductor(@PathVariable("id") Integer id, @ModelAttribute Conductor conductorActualizado) {
        
        // 1. Establecer el ID en el objeto recibido del formulario
        // Asumiendo que el ID del modelo C es 'conductorId' (adaptar si es diferente)
        conductorActualizado.setConductorId(id); 

        // 2. Llamar al servicio de actualización
        Conductor conductorResultado = conductorService.actualizarConductor(id, conductorActualizado);
        
        // Si el servicio devuelve null, se podría manejar el error (opcional)
        if (conductorResultado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar. Conductor no encontrado con ID: " + id);
        }

        // 3. Redirigir a la lista de usuarios
        return "redirect:/listarConductor";
    }
    
    // 7. ELIMINAR USUARIO (DELETE - Borrado Lógico)
    // GET /conductores/eliminar/{id}
    @GetMapping("/eliminarConductor/{id}")
    public String eliminarConductorLogico(@PathVariable("id") Integer id) {

        boolean eliminado = conductorService.eliminarConductorLogico(id);
        
        // Opcional: Manejar si no se encuentra el ID para eliminar
        if (!eliminado) {
            // Esto es opcional, ya que solo redirigirá, pero es buena práctica saber si funcionó
            System.out.println("Advertencia: Intento de eliminar conductor con ID " + id + " no encontrado.");
        }

        // Redirige al conductor a la lista principal después de la operación
        return "redirect:/listarConductor";
    }
}