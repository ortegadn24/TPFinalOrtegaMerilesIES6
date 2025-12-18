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

    // --- NUEVO --- Redirigir /viaje a la selección de usuario
    @GetMapping
    public String index() {
        return "redirect:/viaje/seleccionarUsuario";
    }

    // Paso 1 → Seleccionar usuario
    @GetMapping("/seleccionarUsuario")
    public String seleccionarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarioActivos());
        return "listaViaje"; 
    }

    // Paso 2 → Seleccionar vehículo
    @GetMapping("/seleccionarVehiculo/{usuarioId}")
    public String seleccionarVehiculo(@PathVariable Integer usuarioId, Model model) {
        model.addAttribute("usuario", usuarioService.obtenerUsuarioPorId(usuarioId).orElse(null));
        model.addAttribute("vehiculos", vehiculoService.obtenerTodosVehiculoActivos());
        return "viajeForm"; 
    }

    // Paso 3 → Guardar viaje
    @PostMapping("/guardar")
    public String guardar(@RequestParam Integer usuarioId,
                          @RequestParam Integer vehiculoId,
                          @RequestParam String tipoDistancia,
                          Model model) {

        Usuario usuario = usuarioService.obtenerUsuarioPorId(usuarioId).orElse(null);
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(vehiculoId).orElse(null);

        Viaje viajeGuardado = viajeService.registrarViaje(usuario, vehiculo, tipoDistancia);

        model.addAttribute("viaje", viajeGuardado);
        model.addAttribute("usuario", usuario);
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("conductor", vehiculo != null ? vehiculo.getConductor() : null);

        return "resumenViaje";
}
}
