package com.example.ExamenSpringBoot.repositories;

import com.example.ExamenSpringBoot.entities.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
}
