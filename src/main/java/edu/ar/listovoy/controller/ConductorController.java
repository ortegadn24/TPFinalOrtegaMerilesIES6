package edu.ar.listovoy.controller;

import edu.ar.listovoy.model.Conductor;
import edu.ar.listovoy.service.ConductorService; 
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Controller

public class ConductorController {

    private final ConductorService conductorService;

    // Inyección de Dependencias por Constructor
    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    // --- MÉTODOS CRUD (CREATE, READ, UPDATE, DELETE) ---

    // 1-Muestra la lista de c activos 
    @GetMapping("/listarConductor")
    public String listarConductoresActivos(Model model) {
        // Obtenemos solo los c activos usando el método del servicio
        List<Conductor> conductores = conductorService.obtenerTodosConductorActivos();
        //agregando un campo vavio
        model.addAttribute("listaConductor", conductores); // Usamos "listaConductor" para la vista
        return "listaConductor"; // Retorna el nombre de la plantilla HTML
    }

    // 2 Muestra el formulario para registrar un nuevo c
  
    @GetMapping("/conductor")
    public String mostrarFormularioRegistro(Model model) {
        // Agregamos un objeto C vacío
        model.addAttribute("conductor", new Conductor());
        // El atributo 'isEdit' 
        model.addAttribute("isEdit", false); 
        return "conductor"; // Vista HTML de conductor
    }

    // 3 Guardar nuevo conductor (CREATE)
    
    @PostMapping("/guardarC")
    public String guardarConductor(@ModelAttribute Conductor conductor) {
        // El servicio guarda el objeto enviado desde el formulario
        conductorService.guardaConductor(conductor);

        // Retorna al c a la lista unica  después de guardar
        return "redirect:/listarConductor";
    }
    
   
    
    // 4 MOSTRAR FORMULARIO PARA EDITAR (UPDATE - GET)
  
    @GetMapping("/modificarConductor/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        
        //  Obtener el usuario por ID
        Conductor conductor = conductorService.obtenerConductorPorId(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conductor no encontrado para editar con ID: " + id));
        
        //  Agregar el usuario encontrado y la bandera de edición
        model.addAttribute("conductor", conductor);
        model.addAttribute("isEdit", true); 
        
        //  Reutilizae la vista del formulario
        return "conductor";
    }

    // 5. PROCESAR ACTUALIZACIÓN (UPDATE - POST)
    
    @PostMapping("/actualizarConductor/{id}")
    public String actualizarConductor(@PathVariable("id") Integer id, @ModelAttribute Conductor conductorActualizado) {
        
        //  Establece el ID en el objeto recibido del formulario
        // Asumiendo que el ID del modelo C es 'conductorId' 
        conductorActualizado.setConductorId(id); 

        // . Llamar al servicio de actualización
        Conductor conductorResultado = conductorService.actualizarConductor(id, conductorActualizado);
        
        // Si el servicio devuelve null, se podría tirara un error (opcional)
        if (conductorResultado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar. Conductor no encontrado con ID: " + id);
        }

        //  Retorna a la lista de usuarios
        return "redirect:/listarConductor";
    }
    
    // 6 ELIMINAR USUARIO (DELETE - Borrado Lógico)
  
    @GetMapping("/eliminarConductor/{id}")
    public String eliminarConductorLogico(@PathVariable("id") Integer id) {

        boolean eliminado = conductorService.eliminarConductorLogico(id);
        
        // Opcion por si no se encuentra el id a borrar
        if (!eliminado) {
            // Esto es opcional, ya que solo redirigirá.
            System.out.println("Advertencia: Intento de eliminar conductor con ID " + id + " no encontrado.");
        }

        // Retorna al conductor a la lista inicial después del proceso de eliminacion
        return "redirect:/listarConductor";
    }
}