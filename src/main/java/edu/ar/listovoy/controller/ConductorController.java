package edu.ar.listovoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import edu.ar.listovoy.model.Conductor;


@Controller
public class ConductorController {

    Conductor nuevoConductor = new Conductor ();  //aqui creamos un objeto nuevo alumno de tipo Alumno- en un constructur vacio

    @GetMapping("/conductores")
    public String getConductores() {

     
        return "detalleConductor"; // Nombre del HTML que quieras mostrar
    }
}
