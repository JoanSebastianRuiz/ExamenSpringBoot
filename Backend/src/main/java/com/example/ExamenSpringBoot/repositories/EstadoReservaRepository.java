package com.example.ExamenSpringBoot.repositories;

import com.example.ExamenSpringBoot.entities.EstadoReserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoReservaRepository extends CrudRepository<EstadoReserva, Integer> {
    Optional<EstadoReserva> findByNombre(String nombre);
}
