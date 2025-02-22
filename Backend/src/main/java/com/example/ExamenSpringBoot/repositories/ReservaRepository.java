package com.example.ExamenSpringBoot.repositories;

import com.example.ExamenSpringBoot.entities.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
    List<Reserva> findByUsuarioId(Integer usuarioId);
    List<Reserva> findByFechaAndEstadoReservaId(Date fecha, Integer estadoId);
}
