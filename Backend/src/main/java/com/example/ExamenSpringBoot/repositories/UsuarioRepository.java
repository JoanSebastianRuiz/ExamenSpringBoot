package com.example.ExamenSpringBoot.repositories;

import com.example.ExamenSpringBoot.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByDocumento(String documento);
}
