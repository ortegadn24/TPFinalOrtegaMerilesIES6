package edu.ar.listovoy.service;

import java.util.List;
import edu.ar.listovoy.model.Viaje;

public interface ViajeService {
    // declaración de metodos
    // nominativo solo nombre

    public void borrarViaje(Integer id);
     public void agregarViaje (Viaje Viaje);
     public void modificarViaje (Viaje Viaje);
     public List<Viaje> listarTodosViajes ();
     public Viaje buscarUnVehiculo(Integer id);
     public Viaje buscarUnViajePorNombre (String nombre) ;
     public Viaje crearNuevoViaje (Viaje Viaje);
    
}

