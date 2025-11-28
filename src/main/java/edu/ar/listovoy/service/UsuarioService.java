package edu.ar.listovoy.service;



import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Indica a Spring que esta clase es un componente de servicio
@Service
public class UsuarioService {

    // Inyección de dependencias: permite usar los métodos del Repository
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Métodos CRUD (5 métodos requeridos) 

    // 1. CREAR / GUARDAR (Create)
    /**
     * Guarda un nuevo cliente o actualiza uno existente.
     *  El objeto Cliente a conservar.
     *  El objeto Cliente guardado/actualizado.
     */
    public Usuario guardaUsuario(Usuario usuario) {
        //
        return usuarioRepository.save(usuario);
    }
    
    // 2. "LEER TODOS' - Filtrado por Borrado Lógico
    /**
     * Obtiene todos los clientes cuyo estado es TRUE (activos).
     *  Lista de clientes activos.
     */
    //

    public List<Usuario> obtenerTodosUsuarioActivos() {
    // Llama al método corregido
    return usuarioRepository.findByEstadoUsuario(true); 
}
    
    // 3. LEER POR ID (Read By ID)
    /**
     * Obtiene un cliente por su ID, independientemente de su estado (activo o inactivo).
     *  El ID del cliente a buscar.
     *  Un objeto Optional que puede contener el Cliente.
     */
    public Optional<Usuario> obtenerUsuarioPorId(Integer usuarioId) {
        // Usamos findById que devuelve un Optional para manejar la posible ausencia del cliente.
        return usuarioRepository.findById(usuarioId);
    }
    
    // 4. ACTUALIZAR (Update)
    /**
     * Actualiza la información de un cliente existente.
     * id El ID del cliente a actualizar.
     */
    public Usuario actualizarUsuario(Integer usuarioId, Usuario detallesUsuario) {
        //  Busca el cliente existente
        return usuarioRepository.findById(usuarioId).map(usuarioExistente -> {
            // Actualiza los campos (se asume que el ID ya está validado)
            usuarioExistente.setNombre(detallesUsuario.getNombre());
            usuarioExistente.setApellido(detallesUsuario.getApellido());
            usuarioExistente.setEmail(detallesUsuario.getEmail());
           
          
            
            // Guarda la entidad actualizada
            return usuarioRepository.save(usuarioExistente);
        }).orElse(null); // Devuelve null si no encuentra el cliente
    }

    // 5. ELIMINAR (Delete) - Borrado Lógico
    /**
     * Realiza un borrado lógico, cambiando el atributo 'estado' a FALSE.
     *  El ID del cliente a desactivar.
     */
    public boolean eliminarUsuarioLogico(Integer usuarioId) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuarioId);    
        if (usuarioEncontrado.isPresent()) {
            Usuario usuario = usuarioEncontrado.get();
            usuario.setEstadoUsuario(false); // 🔑 Borrado Lógico
            usuarioRepository.save(usuario); // Persiste el cambio de estado
            return true;
        }
        return false; // Cliente no encontrado para eliminar
    }
}