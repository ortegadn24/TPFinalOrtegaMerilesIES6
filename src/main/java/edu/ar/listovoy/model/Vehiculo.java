package edu.ar.listovoy.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Vehiculo {
    //atributos
    @Id
    private Integer patente;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String tipoVehiculo;
    @Column
    private boolean estadoVehiculo;

    public Vehiculo (){

    }
    public Vehiculo (Integer patente,String marca,String modelo,String tipoVehiculo,boolean estadoVehiculo){
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.estadoVehiculo = estadoVehiculo;
    }

    // metodos particulares o accesores de los atributos

    public Integer getPatente() {
        return patente;
    }

      public void setPatente(Integer patente) {
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

    public boolean getEstadoVehiculo() {
        return estadoVehiculo;
    }

     public void setEstadoVehiculo(boolean estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }
    

}

