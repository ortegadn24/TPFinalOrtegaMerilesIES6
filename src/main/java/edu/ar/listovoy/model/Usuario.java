package edu.ar.listovoy.model;

import java.util.ArrayList;

import jakarta.persistence.*;

   
@Entity 
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId; // PK


    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;
    
    @Column
    private boolean estado;
    




    // Relación 1:N con Compras: Un Cliente hace muchas Compras.
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Compra> comprasRealizadas = new ArrayList<>();

    // Atributo de Borrado Lógico
    @Column(nullable = false)
    private boolean estado = true;
 


    public Usuario() {}  // constructor vacio

    // Constructores con parametros (sin relaciones)
    public Usuario(String nombre, String apellido, String email, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.estado = true;
    }

    // Getters y Setters
    public Integer getUsuarioId() { return usuarioId; }
    public void setId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}





