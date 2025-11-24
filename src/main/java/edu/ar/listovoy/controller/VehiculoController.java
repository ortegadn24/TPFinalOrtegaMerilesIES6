package edu.ar.listovoy.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ar.listovoy.model.Vehiculo;
import edu.ar.listovoy.service.VehiculoService;

@Controller
public class VehiculoController {
    
    @Autowired
    
    private VehiculoService vehiculoService;

    @GetMapping("/Vehiculo")
    public ModelAndView getVehiculo() {

        ModelAndView carrito = new ModelAndView("Vehiculo");
        carrito.addObject("nuevoVehiculo", vehiculoService.crearNuevoVehiculo());
        return carrito;
    }

    @PostMapping("/vehiculoGuardar")
    public ModelAndView saveVehiculo(@ModelAttribute("nuevoVehiculo") Vehiculo vehiculoParaGuardar) {

        vehiculoService.agregarVehiculo(vehiculoParaGuardar);

        ModelAndView mav = new ModelAndView("listaVehiculo");
        mav.addObject("lista", vehiculoService.listarTodosVehiculos());

        System.out.println("Vehículo guardado correctamente");
        return mav;
    }
}

    


   


    








