package edu.ar.listovoy.model;

import jakarta.persistence.*;


@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conductorId;

    private String nombre;
    private String vehiculo;
    private String patente;

    public Conductor() {}

      // constructores con parametros sin relacion
    public Conductor(String nombre, String vehiculo, String patente) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
        this.patente = patente;
    }

    // Getters y Setters
    public Integer getConductorId() { return conductorId; }
    public void setConductorId(Integer conductorId) { this.conductorId = conductorId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getVehiculo() { return vehiculo; }
    public void setVehiculo(String vehiculo) { this.vehiculo = vehiculo; }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
}


