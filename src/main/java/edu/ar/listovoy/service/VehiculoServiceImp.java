package edu.ar.listovoy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Vehiculo;
 @Service
public class VehiculoServiceImp implements VehiculoService {

    @Override
    public void borrarVehiculo(Integer Patente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarVehiculo'");
    }

    @Override
    public void agregarVehiculo(Vehiculo Vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarVehiculo'");
    }

    @Override
    public void modificarVehiculo(Vehiculo Vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarVehiculo'");
    }

    @Override
    public List<Vehiculo> listarVehiculos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarVehiculos'");
    }

    @Override
    public Vehiculo buscarUnVehiculo(Integer Patente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnVehiculo'");
    }

    @Override
    public Vehiculo buscarUnVehiculoPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnVehiculoPorNombre'");
    }

    @Override
    public Vehiculo crearNuevoVehiculo() { 
        // lógica para crear nuevo Vehiculo
        Vehiculo nuevoVehiculo = new Vehiculo ();
        return nuevoVehiculo;

       
    }
    
}
