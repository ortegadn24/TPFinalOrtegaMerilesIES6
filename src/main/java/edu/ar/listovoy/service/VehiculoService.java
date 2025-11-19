package edu.ar.listovoy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Vehiculo;

@Service
public interface VehiculoService {
    // declaración de metodos
    // nominativo solo nombre

    public void borrarVehiculo(Integer Patente);
     public void agregarVehiculo (Vehiculo Vehiculo);
     public void modificarVehiculo (Vehiculo Vehiculo);
     public List<Vehiculo> listarVehiculos ();
     public Vehiculo buscarUnVehiculo(Integer Patente);
     public Vehiculo buscarUnVehiculoPorNombre (String nombre) ;
     public Vehiculo crearNuevoVehiculo ();
    
}
