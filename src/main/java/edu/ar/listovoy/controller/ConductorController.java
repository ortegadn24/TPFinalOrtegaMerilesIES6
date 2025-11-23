package edu.ar.listovoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import edu.ar.listovoy.model.Conductor;


@Controller
public class ConductorController {

    Conductor nuevoConductor = new Conductor ();  //aqui creamos un objeto nuevoConductor de tipo Conductor- en un constructor vacio

    @GetMapping("/conductores")
    public String getConductores() {

     
        return "conductor"; // Nombre del HTML que quieras mostrar
    }
}
