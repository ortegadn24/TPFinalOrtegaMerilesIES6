package edu.ar.listovoy.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;


@Component
public class Vehiculo {

    private Integer Patente;
    private String Marca;
    private String Modelo;
    private String TipoVehiculo;
    private boolean EstadoVehiculo;

    public Vehiculo (){

    }
    public Vehiculo (Integer Patente,String Marca,String Modelo,String TipoVehiculo,boolean EstadoVehiculo){
        this.Patente = Patente;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.TipoVehiculo = TipoVehiculo;
        this.EstadoVehiculo = EstadoVehiculo;
    }

    // metodos particulares o accesores de los atributos

    public Integer getPatente() {
        return Patente;
    }

      public void setPatente(Integer Patente) {
        this.Patente = Patente;
    }

        public String getMarca() {
        return Marca;
    }

     public void setMarca(String Marca) {
        this.Marca = Marca;
    }

      public String getModelo() {
        return Modelo;
    }

     public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

     public String getTipoVehiculo() {
        return TipoVehiculo;
    }

     public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    public boolean getEstadoVehiculo() {
        return EstadoVehiculo;
    }

     public void setEstadoVehiculo(boolean EstadoVehiculo) {
        this.EstadoVehiculo = EstadoVehiculo;
    }
    

}

