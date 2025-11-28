package edu.ar.listovoy.controller;

import edu.ar.listovoy.model.Vehiculo;
import edu.ar.listovoy.service.VehiculoService; // Asegúrate de que este sea el Service con los 5 métodos
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Controller
//@RequestMapping("/usuario") // Prefijo para todas las rutas del controlador (opcional pero recomendado)
public class VehiculoController {

    private final VehiculoService vehiculoService;

    // Inyección de Dependencias por Constructor
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    // --- MÉTODOS CRUD (CREATE, READ, UPDATE, DELETE) ---

    // 1. Mostrar la lista de vehiculo activos (READ ALL - Vista Principal)
    // GET /vehiculo/
    @GetMapping("/listarVehiculo")
    public String listarVehiculoActivos(Model model) {
        // Obtenemos solo los vehiculos activos usando el método del servicio
        List<Vehiculo> vehiculos = vehiculoService.obtenerTodosVehiculoActivos();

        model.addAttribute("listaVehiculo", vehiculos); // Usamos "listaVehiculo" para la vista
        return "listaVehiculo"; // Retorna el nombre de la plantilla HTML
    }

    // 2. Mostrar el formulario para registrar un nuevo vehiculo
    // GET /vehiculo/nuevo
    @GetMapping("/vehiculo")
    public String mostrarFormularioRegistro(Model model) {
        // Agregamos un objeto Vehiculo vacío
        model.addAttribute("vehiculo", new Vehiculo());
        // El atributo 'isEdit' puede ser útil para la vista
        model.addAttribute("isEdit", false); 
        return "vehiculo"; // Vista HTML del formulario
    }

    // 3. Guardar nuevo vehiculo (CREATE)
    // POST /vehiculo/guardar
    @PostMapping("/guardar")
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        // El servicio guarda el objeto enviado desde el formulario
        vehiculoService.guardarVehiculo(vehiculo);

        // Redirige al vehiculo a la lista principal después de guardar
        return "redirect:/listarVehiculo";
    }
    
    // 4. VER DETALLE DEL Vehiculo (READ By ID)
    

       

    
    // 5. MOSTRAR FORMULARIO PARA EDITAR (UPDATE - GET)
    // GET /vehiculo/editar/{patente}
    @GetMapping("/modificarVehiculo/{vehiculoId}")
    public String mostrarFormularioEdicion(@PathVariable("vehiculoId") Integer vehiculoId, Model model) {
        
        // 1. Obtener el usuario por ID, lanzando 404 si no existe
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(vehiculoId)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehiculo no encontrado para editar con Id: " + vehiculoId));
        
        // 2. Agregar el vehiculo encontrado y la bandera de edición
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("isEdit", true); 
        
        // 3. Reutilizar la vista del formulario
        return "vehiculo";
    }

    // 6. PROCESAR ACTUALIZACIÓN (UPDATE - POST)
    // POST /usuarios/actualizar/{id}
    @PostMapping("/actualizarVehiculo/{vehiculoId}")
    public String actualizarVehiculo(@PathVariable("vehiculoId") Integer vehiculoId, @ModelAttribute Vehiculo vehiculoActualizado) {
        
        // 1. Establecer el ID en el objeto recibido del formulario
        // Asumiendo que el ID del modelo Usuario es 'usuarioId' (adaptar si es diferente)
        vehiculoActualizado.setVehiculoId(vehiculoId); 

        // 2. Llamar al servicio de actualización
        Vehiculo vehiculoResultado = vehiculoService.actualizarVehiculo(vehiculoId, vehiculoActualizado);
        
        // Si el servicio devuelve null, se podría manejar el error (opcional)
        if (vehiculoResultado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar. Vehiculo no encontrado con vehiculoId: " + vehiculoId);
        }

        // 3. Redirigir a la lista de vehiculo
        return "redirect:/listarVehiculo";
    }
    
    // 7. ELIMINAR Vehiculo (DELETE - Borrado Lógico)
    // GET /vehiculo/eliminar/{id}
    @GetMapping("/eliminarVehiculo/{vehiculoId}")
    public String eliminarVehiculoLogico(@PathVariable("vehiculoId") Integer vehiculoId) {

        boolean eliminado = vehiculoService.eliminarVehiculoLogico(vehiculoId);
        
        // Opcional: Manejar si no se encuentra el ID para eliminar
        if (!eliminado) {
            // Esto es opcional, ya que solo redirigirá, pero es buena práctica saber si funcionó
            System.out.println("Advertencia: Intento de eliminar vehiculo con vehiculoId " + vehiculoId + " no encontrado.");
        }

        // Redirige al usuario a la lista principal después de la operación
        return "redirect:/listarVehiculo";
    }
}
    


   


    








