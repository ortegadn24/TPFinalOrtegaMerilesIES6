package edu.ar.listovoy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ar.listovoy.model.Usuario;
import edu.ar.listovoy.service.UsuarioService;
import edu.ar.listovoy.service.UsuarioService;


@Controller
public class UsuarioController{

    private final UsuarioService usuarioService;

    //atributo de la clase
   
    @Qualifier("servicioUsuarioMySQL")
    @Autowired
    UsuarioService uService;

    UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarioo")

  public ModelAndView getUsuario () {
    //public string getUsuario() {

    //Usuario nuevoUsuario = new Usuario();

    //nuevoUsuario.setApellido(apellido: "Nuevo Apellido");
    //nuevoUsuario.setNombre(nombre: "Nuevo Nombre");
    //nuevoUsuario.setEmail(email:  "Nuevo Email");
    

    ModelAndView carrito = new ModelAndView("usuario");
    //codigo
    //return "alumno"
    carrito.addObject("nuevoUsuario", usuarioService.crearNuevoUsuario() );
    return carrito;

   }
    @PostMapping("/guardarUsuario") 
    public ModelAndView  saveUsuario(@ModelAttribute("nuevoUsuario") Usuario usuarioParaGuardar){

        usuarioService.agregarUsuario(usuarioParaGuardar);
        ModelAndView modelView = new ModelAndView("listaUsuarios");
        System.out.println("usuario guardado correctamente");
        modelView.addObject("lista", usuarioService.listarTodosUsuario());
        return modelView;
    }
      
     
        
        
    
    
}

  


  
      

   //atributos                 //constructor sin parametro
     

  //metodos
  //@GetMapping("/usuarioo")
  //public String getUsuario()

  //return "usuario";
    

     
        




    
