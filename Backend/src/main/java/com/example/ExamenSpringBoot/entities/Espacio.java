package com.example.ExamenSpringBoot.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_espacio")
    private TipoEspacio tipoEspacio;

    private String nombre;
    private Integer capacidad;
    private Boolean disponibilidad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espacio", fetch = FetchType.LAZY, orphanRemoval = true)
    List<Reserva> reservas;

    public Espacio() {
    }

    public Espacio(Integer id, TipoEspacio tipoEspacio, String nombre, Integer capacidad, Boolean disponibilidad, List<Reserva> reservas) {
        this.id = id;
        this.tipoEspacio = tipoEspacio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
        this.reservas = reservas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoEspacio getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(TipoEspacio tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
