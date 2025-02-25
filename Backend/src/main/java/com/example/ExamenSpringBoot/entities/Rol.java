package com.example.ExamenSpringBoot.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch =
            FetchType.LAZY, orphanRemoval = true)
    List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(Integer id, String nombre, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = usuarios;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
