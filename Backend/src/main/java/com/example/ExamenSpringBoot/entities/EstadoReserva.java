package com.example.ExamenSpringBoot.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class EstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoReserva", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Reserva> reservas;

    public EstadoReserva() {
    }

    public EstadoReserva(Integer id, String nombre, List<Reserva> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.reservas = reservas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
