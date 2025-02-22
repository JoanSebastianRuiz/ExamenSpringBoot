package com.example.ExamenSpringBoot.repositories;

import com.example.ExamenSpringBoot.entities.Espacio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface EspacioRepository extends CrudRepository<Espacio, Integer> {
    @Query(value = "select e from espacio e \n" +
            "join reserva r on r.id_espacio=e.id \n" +
            "where e.id not in(select id_espacio where fecha=:fecha and (hora_inicio between :horaInicio and :horaFin or hora_fin between :horaInicio and :horaFin))\n" +
            "and e.id_tipo_espacio=:idTipoEspacio", nativeQuery = true)
    List<Espacio> findEspaciosDisponiblesPorDisponibilidadYTipo(@Param("horaInicio") Time horaInicio, @Param("horaFin") Time horaFin, @Param("fecha") Date fecha, @Param("idTipoEspacio") Integer idTipoEspacio);

}
