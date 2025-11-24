package edu.ar.listovoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Vehiculo;
import edu.ar.listovoy.repository.VehiculoRepository;
@Service
@Qualifier("servicioVehiculoMySQL")


public class  VehiculoServiceImpDB implements VehiculoService  {
    @Autowired
    Vehiculo nuevoVehiculo;

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public void borrarVehiculo(Integer Patente) {
        vehiculoRepository.deleteById(Patente);

     
    }

    @Override
    public void agregarVehiculo(Vehiculo Vehiculo) {
        vehiculoRepository.save(Vehiculo);
    }

    @Override
    public void modificarVehiculo(Vehiculo Vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarVehiculo'");
    }

    @Override
    public List<Vehiculo> listarTodosVehiculos() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
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
        return nuevoVehiculo;
        
    }

    
 

}