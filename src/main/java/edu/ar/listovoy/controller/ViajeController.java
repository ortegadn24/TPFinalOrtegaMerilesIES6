package edu.ar.listovoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ar.listovoy.model.Viaje;
import edu.ar.listovoy.service.ViajeServiceImp;

@Controller
public class ViajeController {

    @Autowired
    @Qualifier("servicioViajeMySQL")
    private ViajeServiceImp viajeService;

    // Mostrar formulario
    @GetMapping("/Viaje")
    public ModelAndView getFormularioViaje() {
        ModelAndView modelo = new ModelAndView("Viaje");
        modelo.addObject("nuevoViaje", viajeService.crearNuevoViaje());
        return modelo;
    }

    // Guardar viaje
    @PostMapping("/guardarViaje")
    public ModelAndView guardarViaje(@ModelAttribute("nuevoViaje") Viaje viajeAGuardar) {

        viajeService.agregarViaje(viajeAGuardar);

        ModelAndView modelo = new ModelAndView("listaViaje");
        modelo.addObject("lista", viajeService.listarTodosLosViajes());

        return modelo;
    }
}
