package edu.ar.listovoy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.model.Vehiculo;
import edu.ar.listovoy.model.Viaje;
import edu.ar.listovoy.service.UsuarioService;
import edu.ar.listovoy.service.VehiculoService;
import edu.ar.listovoy.service.ViajeService;

@Controller
@RequestMapping("/viaje")
public class ViajeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private ViajeService viajeService;

    // Paso 1 → seleccionar usuario
    @GetMapping("/seleccionarUsuario")
    public String seleccionarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarioActivos());
        return "viaje/viajeList";
    }

    

     // Paso 2 → seleccionar vehículo (no enviar un Optional a la vista)
    @GetMapping("/seleccionarVehiculo/{usuarioId}")
    public String seleccionarVehiculo(@PathVariable Integer usuarioId, Model model) {
    // Agregamos .orElse(null) para que el modelo reciba el Usuario y no un Optional
    model.addAttribute("usuario", usuarioService.obtenerUsuarioPorId(usuarioId).orElse(null));
    model.addAttribute("vehiculos", vehiculoService.obtenerTodosVehiculoActivos());
    return "viaje/viajeForm";
}

   //  Paso 3 (guardar)

@PostMapping("/guardar")
public String guardar(@RequestParam Integer usuarioId, @RequestParam Integer vehiculoId, 
                      @RequestParam String tipoDistancia, Model model) {

    Usuario usuario = usuarioService.obtenerUsuarioPorId(usuarioId).orElse(null);
    Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(vehiculoId).orElse(null);

    // Guardamos y obtenemos el objeto ya persistido (con ID y costo)
    Viaje viajeGuardado = viajeService.registrarViaje(usuario, vehiculo, tipoDistancia);

    model.addAttribute("viaje", viajeGuardado); // Usamos el objeto guardado
    model.addAttribute("usuario", usuario);
    model.addAttribute("vehiculo", vehiculo);
    model.addAttribute("conductor", vehiculo != null ? vehiculo.getConductor() : null);

    return "resumenViaje";
}


    // Paso 2 → seleccionar vehículo
   // @GetMapping("/seleccionarVehiculo/{usuarioId}")
    //public String seleccionarVehiculo(@PathVariable Integer usuarioId, Model model) {
      //  model.addAttribute("usuario", usuarioService.obtenerUsuarioPorId(usuarioId));
       // model.addAttribute("vehiculos", vehiculoService.obtenerTodosVehiculoActivos());
        //return "viaje/viajeForm";
   // }

    // Paso 3 → guardar el viaje
    //@PostMapping("/guardar")
   // public String guardar(
          //  @RequestParam Integer usuarioId,
           // @RequestParam Integer vehiculoId,
           // @RequestParam String tipoDistancia,
            //Model model) {

        //Usuario usuario = usuarioService.obtenerUsuarioPorId(usuarioId);
        //Vehiculo vehiculo = vehiculoService. obtenerVehiculoPorId(vehiculoId);

        //Viaje viaje = viajeService.registrarViaje(usuario, vehiculo, tipoDistancia);

        //model.addAttribute("viaje", viaje);
       // model.addAttribute("usuario", usuario);
       // model.addAttribute("vehiculo", vehiculo);
       // model.addAttribute("conductor", vehiculo.getConductor());

        //return "resumenViaje";
}



