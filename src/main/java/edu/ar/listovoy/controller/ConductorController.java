package edu.ar.listovoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConductorController {

    @GetMapping("/conductores")
    public String listarConductores() {
        return "conductores"; // Nombre del HTML que quieras mostrar
    }
}
