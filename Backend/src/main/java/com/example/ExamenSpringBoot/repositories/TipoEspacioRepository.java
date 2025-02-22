package com.example.ExamenSpringBoot.repositories;

import com.example.ExamenSpringBoot.entities.TipoEspacio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoEspacioRepository extends CrudRepository<TipoEspacio, Integer> {
    Optional<TipoEspacio> findByNombre(String nombre);
}
