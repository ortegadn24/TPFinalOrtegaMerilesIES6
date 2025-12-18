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


    // Relación 1:1 Conductor/Vehiculo : un conductor tienen un vehiculo. Un vehiculo tiene un conductor
   
    // En Conductor.java
    @OneToOne(mappedBy = "conductor") // "conductor" es el nombre del atributo en la clase Vehiculo
     private Vehiculo vehiculo;

   


   // Atributo de Borrado Lógico
    @Column(nullable = false)
    private boolean estadoConductor= true;

    // Constructor Vacío
    public Conductor() {}


    // Constructor con parámetros (sin relaciones)
    public Conductor(Integer conductorId, String nombre, String apellido,String email,boolean estadoConductor ) {
        this.conductorId = conductorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;  
        this.estadoConductor = estadoConductor;
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

    public Boolean getEstadoConductor() { return estadoConductor; }
    // public void setEstadoConductor(boolean setEstadoConductor) { this.estadoConductor = setEstadoConductor; }
    // Corrección 
    public void setEstadoConductor(boolean estadoConductor) { 
    this.estadoConductor = estadoConductor; }


    public Vehiculo getVehiculo() {
    return vehiculo;}

    public void setVehiculo(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;}




}