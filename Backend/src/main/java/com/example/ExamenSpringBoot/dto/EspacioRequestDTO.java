package com.example.ExamenSpringBoot.dto;

import com.example.ExamenSpringBoot.entities.TipoEspacio;

public class EspacioRequestDTO {
    private Integer idTipoEspacio;
    private String nombre;
    private Integer capacidad;
    private Boolean disponibilidad;

    public EspacioRequestDTO() {
    }

    public EspacioRequestDTO(Integer idTipoEspacio, String nombre, Integer capacidad, Boolean disponibilidad) {
        this.idTipoEspacio = idTipoEspacio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
    }

    public Integer getIdTipoEspacio() {
        return idTipoEspacio;
    }

    public void setIdTipoEspacio(Integer idTipoEspacio) {
        this.idTipoEspacio = idTipoEspacio;
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

    @Override
    public String toString() {
        return "EspacioRequestDTO{" +
                "idTipoEspacio=" + idTipoEspacio +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}
