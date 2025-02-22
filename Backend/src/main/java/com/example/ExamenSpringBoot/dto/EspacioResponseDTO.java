package com.example.ExamenSpringBoot.dto;

public class EspacioResponseDTO {
    private String nombreTipoEspacio;
    private String nombre;
    private Integer capacidad;
    private Boolean disponibilidad;

    public EspacioResponseDTO() {
    }

    public EspacioResponseDTO(String nombreTipoEspacio, String nombre, Integer capacidad, Boolean disponibilidad) {
        this.nombreTipoEspacio = nombreTipoEspacio;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
    }

    public String getNombreTipoEspacio() {
        return nombreTipoEspacio;
    }

    public void setNombreTipoEspacio(String nombreTipoEspacio) {
        this.nombreTipoEspacio = nombreTipoEspacio;
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
}
