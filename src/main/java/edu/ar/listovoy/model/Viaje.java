package edu.ar.listovoy.model;

import org.springframework.stereotype.Component;

@Component
public class Viaje {
    private Integer ViajeId;
    private String TipoViaje;
    private String Costo;
    private String Fecha;
    private boolean EstadoViaje;

    public Viaje (){

    }
    public Viaje (Integer ViajeId,String TipoViaje,String Costo,String Fecha,boolean EstadoViaje){
        this.ViajeId = ViajeId;
        this.TipoViaje = TipoViaje;
        this.Costo = Costo;
        this.Fecha = Fecha;
        this.EstadoViaje = EstadoViaje;
    }

    // metodos particulares o accesores de los atributos

    public Integer getViajeId() {
        return ViajeId;
    }

      public void setViajeId(Integer ViajeId) {
        this.ViajeId = ViajeId;
    }

        public String getTipoViaje() {
        return TipoViaje;
    }

     public void setTipoViaje(String TipoViaje) {
        this.TipoViaje = TipoViaje;
    }

      public String getCosto() {
        return Costo;
    }

     public void setCosto(String Costo) {
        this.Costo = Costo;
    }

     public String getFecha() {
        return Fecha;
    }

     public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public boolean getEstadoViaje() {
        return EstadoViaje;
    }

     public void setEstado(boolean EstadoViaje) {
        this.EstadoViaje = EstadoViaje;
    }
    

}