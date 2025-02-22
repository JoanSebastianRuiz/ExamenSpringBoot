package com.example.ExamenSpringBoot.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TipoEspacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEspacio", fetch =
            FetchType.LAZY, orphanRemoval = true)
    private List<Espacio> espacios;

    public TipoEspacio() {
    }

    public TipoEspacio(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
