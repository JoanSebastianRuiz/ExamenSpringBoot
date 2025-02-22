package com.example.ExamenSpringBoot.dto;

import com.example.ExamenSpringBoot.entities.Espacio;
import com.example.ExamenSpringBoot.entities.EstadoReserva;
import com.example.ExamenSpringBoot.entities.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.sql.Time;

public class ReservaRequestDTO {
    private String documentoUsuario;
    private Integer idEspacio;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    public ReservaRequestDTO() {
    }

    public ReservaRequestDTO(String documentoUsuario, Integer idEspacio, Date fecha, Time horaInicio, Time horaFin) {
        this.documentoUsuario = documentoUsuario;
        this.idEspacio = idEspacio;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public Integer getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Integer idEspacio) {
        this.idEspacio = idEspacio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
}
