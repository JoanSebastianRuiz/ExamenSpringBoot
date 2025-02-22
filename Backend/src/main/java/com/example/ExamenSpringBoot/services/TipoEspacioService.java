package com.example.ExamenSpringBoot.services;

import com.example.ExamenSpringBoot.dto.TipoEspacioResponseDTO;
import com.example.ExamenSpringBoot.entities.TipoEspacio;
import com.example.ExamenSpringBoot.repositories.TipoEspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoEspacioService {
    @Autowired
    private TipoEspacioRepository tipoEspacioRepository;

    public ResponseEntity<?> obtenerTipoEspacios(){
        try{
            List<TipoEspacio> tipoEspacios = (List<TipoEspacio>) tipoEspacioRepository.findAll();
            List<TipoEspacioResponseDTO> tipoEspacioResponseDTOS = tipoEspacios.stream().map(tipoEspacio -> {
                return new TipoEspacioResponseDTO(tipoEspacio.getId(), tipoEspacio.getNombre());
            }).collect(Collectors.toList());

            return ResponseEntity.ok(tipoEspacioResponseDTOS);

        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Error obteniendo tipos de espacios");
        }
    }
}
