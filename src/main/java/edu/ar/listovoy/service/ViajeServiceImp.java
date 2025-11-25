package edu.ar.listovoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Viaje;
import edu.ar.listovoy.repository.ViajeRepository;

@Service("servicioViajeMySQL")
public class ViajeServiceImp implements ViajeService {

    @Override
    public void borrarViaje(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarViaje'");
    }

    @Override
    public void agregarViaje(Viaje Viaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarViaje'");
    }

    @Override
    public void modificarViaje(Viaje Viaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarViaje'");
    }

    @Override
    public List<Viaje> listarTodosViajes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosViajes'");
    }

    @Override
    public Viaje buscarUnVehiculo(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnVehiculo'");
    }

    @Override
    public Viaje buscarUnViajePorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnViajePorNombre'");
    }

    @Override
    public Viaje crearNuevoViaje(Viaje Viaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearNuevoViaje'");
    }

   
    }


    


   

    
}