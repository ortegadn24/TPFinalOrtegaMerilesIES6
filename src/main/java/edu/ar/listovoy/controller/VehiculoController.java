package edu.ar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ar.listovoy.model.Vehiculo;
import edu.ar.listovoy.service.VehiculoServiceImp;

@Controller
public class VehiculoController {

    


    // atributos
    List <Vehiculo> listadoDeVehiculos = new ArrayList <Vehiculo> ();
    VehiculoServiceImp VehiculoService;
    




    @GetMapping ("/Vehiculo")
    public ModelAndView getVehiculo () {
        // public String getVehiculo

        // Vehiculo nuevoVehiculo = new Vehiculo ();

        VehiculoService.crearNuevoVehiculo();



        // dentro del metodo he definido los datos del vehiculo
        // nuevoVehiculo 
        //VehiculoService.crearNuevoVehiculo();

        ModelAndView carrito = new ModelAndView ("Vehiculo");


        // codigo 
        // return "Vehiculo" este Vehiculo es el nombre de la vista cuando defino vista, la vista se llama Vehiculo
        carrito.addObject("nuevoVehiculo", VehiculoService.crearNuevoVehiculo());
        return carrito;

    }
       // metodo que recibe a ese Vehiculo , que ahora si tiene datos, @PostMappin recibe
       @PostMapping("/guardarVehiculo")
       public ModelAndView saveVehiculo(@ModelAttribute("nuevoVehiculo")Vehiculo VehiculoParaGuardar) {
        // estructura de datos que permita almacenar datos
        // guardar el Vehiculo

        //List <Vehiculo> listadoDeVehiculos = new ArrayList <Vehiculo> ();
        listadoDeVehiculos.add(VehiculoParaGuardar);

        VehiculoService.agregarVehiculo(VehiculoParaGuardar);
        ModelAndView ModelView = new ModelAndView ("listaVehiculo");

        System.out.println("Vehiculo guardado correctamente");
        //  System.out.println(listadoDeVehiculo.size());
        ModelView.addObject("lista",VehiculoService.listarTodosVehiculos());
        return ModelView;


       }


    







}
