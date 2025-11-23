package edu.ar.listovoy.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity 
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usuarioId; // PK


    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;
    
    @Column
    private boolean estadoUsuario;


    // Relación N:1  Un Usuario realiza muchos Viajes.
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Viaje> viajesRealizados = new ArrayList<>();

    // Atributo de Borrado Lógico
    @Column(nullable = false)
    private boolean estado= true;
 
   // Constructores, Getters y Setters

    public Usuario() {}  // constructor vacio

    // Constructores con parametros (sin relaciones)
    public Usuario(String nombre, String apellido, String email, boolean estadoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.estadoUsuario = true;
    }

    // Getters y Setters
    public String getUsuarioId() { return usuarioId; }
    public void setId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean getEstadoUsuario() { return estadoUsuario; }
    public void setEstadoUsuario(boolean estadoUsuario) { this.estadoUsuario = estadoUsuario; }
}





