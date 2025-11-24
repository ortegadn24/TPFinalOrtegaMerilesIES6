package edu.ar.listovoy.service;

import java.util.List;
import edu.ar.listovoy.model.Viaje;

public interface ViajeService {

    Viaje crearNuevoViaje(Viaje viaje);

    void agregarViaje(Viaje viaje);

    List<Viaje> listarTodosLosViajes();
}
