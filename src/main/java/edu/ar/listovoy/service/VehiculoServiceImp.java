package edu.ar.listovoy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Vehiculo;
 @Service
 @Qualifier("servicioVehiculoArrayList")
public class VehiculoServiceImp implements VehiculoService {

     List <Vehiculo> listadoDeVehiculos = new ArrayList <Vehiculo> ();

    @Autowired
    Vehiculo nuevoVehiculo;

    @Override
    public void borrarVehiculo(Integer Patente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarVehiculo'");
    }

    @Override
    public void agregarVehiculo(Vehiculo Vehiculo) {
         listadoDeVehiculos.add(Vehiculo);
         System.out.println(listadoDeVehiculos.size());
    
    }

    @Override
    public void modificarVehiculo(Vehiculo Vehiculo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarVehiculo'");
    }

    @Override
    public  List<Vehiculo> listarTodosVehiculos() {
        return listadoDeVehiculos;
      
       
    }

    @Override
    public Vehiculo buscarUnVehiculo(Integer Patente) {
        return listadoDeVehiculos.strean()
       
    }

    @Override
    public Vehiculo buscarUnVehiculoPorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnVehiculoPorNombre'");
    }

    @Override
    public Vehiculo crearNuevoVehiculo() { 
        // lógica para crear nuevo Vehiculo
        //Vehiculo nuevoVehiculo = new Vehiculo ();
        return new Vehiculo();

       
    }
    
}
