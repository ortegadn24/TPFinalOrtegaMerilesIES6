package edu.ar.listovoy.service;


import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.model.Vehiculo;
import edu.ar.listovoy.model.Viaje;
import edu.ar.listovoy.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    // Listar todos los viajes
    public List<Viaje> listarTodos() {
        return viajeRepository.findAll();
    }

    // Listar viajes activos
    public List<Viaje> listarActivos() {
        return viajeRepository.findByEstadoTrue();
    }

    // Guardar viaje (CRUD básico)
    public Viaje guardar(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    // Buscar por ID
    public Viaje buscarPorId(Integer id) {
        return viajeRepository.findById(id).orElse(null);
    }

    // Borrado lógico
    public void eliminarLogico(Integer id) {
        Viaje viaje = buscarPorId(id);
        if (viaje != null) {
            viaje.setEstado(false);
            viajeRepository.save(viaje);
        }
    }



    public Viaje registrarViaje(Usuario usuario, Vehiculo vehiculo, String tipoDistancia) {
    Viaje viaje = new Viaje();
    viaje.setUsuario(usuario);
    viaje.setVehiculo(vehiculo);
    viaje.setTipoDistancia(tipoDistancia);
    viaje.setEstado(true);
    
    //  Determinar el costo base según la distancia
    double costoBase = 0;
    switch (tipoDistancia.toUpperCase()) {
        case "CORTA":
            costoBase = 7000.0;
            break;
        case "MEDIA":
            costoBase = 7000.0; 
            break;
        case "LARGA":
            costoBase = 20000.0;
            break;
    }

    // Aplica el incremento según el tipo de vehículo
    // (X base = 0%, Luxe = 10%, Premium = 20%)
    double incremento = 0;
    String categoria = vehiculo.getTipoVehiculo().toUpperCase();

    if (categoria.contains("LUXE")) {
        incremento = costoBase * 0.10;
    } else if (categoria.contains("PREMIUM")) {
        incremento = costoBase * 0.20;
    }

    viaje.setCostoFinal(costoBase + incremento);

    return viajeRepository.save(viaje);
}

   
}
