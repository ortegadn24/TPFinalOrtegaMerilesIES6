package edu.ar.listovoy.service;



import edu.ar.listovoy.model.Conductor;
import edu.ar.listovoy.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Indica a Spring que esta clase es un componente de servicio
@Service
public class ConductorService {

    // Inyección de dependencias: permite usar los métodos del Repository
    @Autowired
    private ConductorRepository conductorRepository;

    // Métodos CRUD 

    // 1. CREAR / GUARDAR (Create)
    /**
     * Guarda un nuevo cliente o actualiza uno existente.
     *  El objeto Cliente a conservar
     *  El objeto Cliente guardado/actualizado.
     */
    public Conductor guardaConductor(Conductor conductor) {
        // 
        return conductorRepository.save(conductor);
    }
    
    // 2. "LEER TODOS'  - Filtrado por Borrado Lógico
    /**
     * Obtiene todos los c cuyo estado es TRUE (activos).
     
     *  Lista de c activos.
     */
    // 

    public List<Conductor> obtenerTodosConductorActivos() {
    // Llama al método corregido
    return conductorRepository.findByEstadoConductor(true); 
}
    
    // 3. LEER POR ID 
    /**
     * Obtiene un c por su ID, independientemente de su estado (activo o inactivo).
     *  El ID del c a buscar.
     */
    public Optional<Conductor> obtenerConductorPorId(Integer conductorId) {
        // Usamos findById que devuelve un Optional para manejar la posible ausencia del c.
        return conductorRepository.findById(conductorId);
    }
    
    // 4. ACTUALIZAR (Update)
    /**
     * Actualiza la información de un cliente existente.
     * conductorId El ID del cliente a actualizar.
     */
    public Conductor actualizarConductor(Integer conductorId, Conductor detallesConductor) {
        //  Busca el c existente
        return conductorRepository.findById(conductorId).map(conductorExistente -> {
            //  Actualiza los campos (se asume que el ID ya está validado)
            conductorExistente.setNombre(detallesConductor.getNombre());
            conductorExistente.setApellido(detallesConductor.getApellido());
            conductorExistente.setEmail(detallesConductor.getEmail());
           
            
           
            //  Guarda la entidad actualizada
            return conductorRepository.save(conductorExistente);
        }).orElse(null); // Devuelve null si no encuentra el c
    }

    // 5. ELIMINAR (Delete) - Borrado Lógico
    /**
     * Realiza un borrado lógico, cambiando el atributo 'estado' a FALSE.
     *  El ID del c a desactivar.
     */
    public boolean eliminarConductorLogico(Integer conductorId) {
        Optional<Conductor> conductorEncontrado = conductorRepository.findById(conductorId);    
        if (conductorEncontrado.isPresent()) {
            Conductor conductor = conductorEncontrado.get();
            conductor.setEstadoConductor(false); // 🔑 Borrado Lógico
            conductorRepository.save(conductor); // Persiste el cambio de estado
            return true;
        }
        return false; // C no encontrado para eliminar
    }
}