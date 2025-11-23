package edu.ar.listovoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ar.listovoy.model.Viaje;
import edu.ar.listovoy.repository.ViajeRepository;

@Service("servicioViajeMySQL")
public class ViajeServiceImp implements ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public Viaje crearNuevoViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public void agregarViaje(Viaje viaje) {
        viajeRepository.save(viaje);
    }

    @Override
    public List<Viaje> listarTodosLosViajes() {
        return (List<Viaje>) viajeRepository.findAll();
    }
}