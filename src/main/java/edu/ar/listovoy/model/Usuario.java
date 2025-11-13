package edu.ar.listovoy.model;

import jakarta.persistence.*;

   
@Entity 
public class Usuario {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;  // pk

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Usuario() {}  // constructor vacio

    // Constructores con parametros (sin relaciones)
    public Usuario(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters
    public Integer getUsuarioId() { return usuarioId; }
    public void setId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}




