package edu.ar.listovoy.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Component
@Entity
public class Vehiculo {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental en MySQL
    @Column(name = "vehiculo_id")
    private Integer vehiculoId;
     @Column(name = "patente", unique = true, nullable = false)
    private String patente;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String tipoVehiculo;

    @OneToOne
    @JoinColumn(name="conductorId")
    private Conductor conductor;
    


    // Atributo de borrado lógico

    @Column(nullable=false)
    private Boolean estadoVehiculo=true;

    // Constructor vacio

    public Vehiculo (){
    


    }
    //Constructores con parametros(sin relaciones)
    public Vehiculo (Integer vehiculoId,String patente,String marca,String modelo,String tipoVehiculo,boolean estadoVehiculo){
        this.vehiculoId = vehiculoId;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.estadoVehiculo = estadoVehiculo;
    }

    // metodos particulares o accesores de los atributos
    //Getters y Setters

    public Integer getVehiculoId() {
        return vehiculoId;
    }

      public void setVehiculoId(Integer vehiculoId) {
    
        this.vehiculoId = vehiculoId;

    }
    public String getPatente() {
        return patente;
    }

    public void setPatente (String patente) {
        this.patente = patente;
    }

        public String getMarca() {
        return marca;
    }

     public void setMarca(String marca) {
        this.marca = marca;
    }

      public String getModelo() {
        return modelo;
    }

     public void setModelo(String modelo) {
        this.modelo = modelo;
    }

     public String getTipoVehiculo() {
        return tipoVehiculo;
    }

     public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Boolean getEstadoVehiculo() {
        return estadoVehiculo;
    }

     public void setEstadoVehiculo(Boolean estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }
}
