package edu.ar.listovoy.model;

//import java.util.ArrayList;
//import java.util.List;


import jakarta.persistence.*;

@Entity
public class Conductor {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conductorId; // PK

    
    @Column
    private String nombre;

    @Column
    private String apellido;
    
    @Column
    private String email; 

    @Column
    private boolean estado = true;



    // Relación 1:1 Conductor/Vehiculo : un conductor tienen un vehiculo. Un vehiculo tiene un conductor
   
    @OneToOne
    @JoinColumn(name = "vehiculoId") 
    private Vehiculo vehiculo;


     // Constructor Vacío
    public Conductor() {}


    // Constructor con parámetros (sin relaciones)
    public Conductor(Integer conductorId, String nombre, String apellido,String email,boolean estado ) {
        this.conductorId = conductorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;  
        this.estado = estado;
    }

   // Getter y  setter

    public Integer getConductorId() { return conductorId; }
    public void setConductorId(Integer conductorId) { this.conductorId = conductorId; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }


}