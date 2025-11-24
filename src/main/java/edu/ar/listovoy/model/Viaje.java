package edu.ar.listovoy.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Viaje {
    //atributos
    @Id
    private Integer viajeId;

    @Column
    private String tipoViaje;
    @Column
    private String costo;
    @Column
    private String fecha;
    @Column
    private boolean estadoViaje;

    // --------- RELACIONES -----------

    // Muchos viajes pertenecen a un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")   // FK
    private Usuario usuario;

    // Muchos viajes usan un vehículo
    @ManyToOne
    @JoinColumn(name = "patente")      // FK
    private Vehiculo vehiculo;

    // --------- CONSTRUCTORES -----------



    public Viaje (){
        

    }
    public Viaje (Integer viajeId,String tipoViaje,String costo,String fecha,boolean estadoViaje){
        this.viajeId = viajeId;
        this.tipoViaje = tipoViaje;
        this.costo = costo;
        this.fecha = fecha;
        this.estadoViaje = estadoViaje;
    }

    // metodos particulares o accesores de los atributos

    public Integer getViajeId() {
        return viajeId;
    }

      public void setViajeId(Integer viajeId) {
        this.viajeId = viajeId;
    }

        public String getTipoViaje() {
        return tipoViaje;
    }

     public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

      public String getCosto() {
        return costo;
    }

     public void setCosto(String costo) {
        this.costo = costo;
    }

     public String getFecha() {
        return fecha;
    }

     public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getEstadoViaje() {
        return estadoViaje;
    }

     public void setEstado(boolean estadoViaje) {
        this.estadoViaje = estadoViaje;
    }
    

}