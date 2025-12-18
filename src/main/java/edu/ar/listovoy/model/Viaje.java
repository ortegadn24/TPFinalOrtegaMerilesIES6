package edu.ar.listovoy.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viaje_id")  // ← Añadido para ser explícito
    private Integer viajeId;

    @Column(name = "tipo_distancia", nullable = false)
    private String tipoDistancia;

    @Column(name = "costo_final")
    private Double costoFinal;

    @Column(name = "fecha_viaje")
    private LocalDateTime fechaViaje = LocalDateTime.now();

    // Relaciones - CORREGIDO: nombre de columna con guión bajo
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)  // ← CORREGIDO
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)  // ← CORREGIDO
    private Vehiculo vehiculo;

    // Borrado lógico
    @Column(nullable = false)
    private boolean estado = true;

    public Viaje() {}

    public Viaje(String tipoDistancia, Double costoFinal, Usuario usuario, Vehiculo vehiculo) {
        this.tipoDistancia = tipoDistancia;
        this.costoFinal = costoFinal;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaViaje = LocalDateTime.now();
        this.estado = true;
    }

    // Getters y Setters
    public Integer getViajeId() { return viajeId; }
    public void setViajeId(Integer viajeId) { this.viajeId = viajeId; }

    public String getTipoDistancia() { return tipoDistancia; }
    public void setTipoDistancia(String tipoDistancia) { this.tipoDistancia = tipoDistancia; }

    public Double getCostoFinal() { return costoFinal; }
    public void setCostoFinal(Double costoFinal) { this.costoFinal = costoFinal; }

    public LocalDateTime getFechaViaje() { return fechaViaje; }
    public void setFechaViaje(LocalDateTime fechaViaje) { this.fechaViaje = fechaViaje; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}