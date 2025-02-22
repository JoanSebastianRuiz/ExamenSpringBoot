package com.example.ExamenSpringBoot.services;

import com.example.ExamenSpringBoot.dto.EspacioResponseDTO;
import com.example.ExamenSpringBoot.dto.EstadoReservaResponseDTO;
import com.example.ExamenSpringBoot.entities.EstadoReserva;
import com.example.ExamenSpringBoot.repositories.EstadoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoReservaService {
    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public ResponseEntity<?> obtenerEstadosReserva(){
        try{
            List<EstadoReserva> estadoReservas = (List<EstadoReserva>) estadoReservaRepository.findAll();
            List<EstadoReservaResponseDTO> estadoReservaResponseDTOS = estadoReservas.stream().map(estadoReserva -> new EstadoReservaResponseDTO(estadoReserva.getId(), estadoReserva.getNombre())).collect(Collectors.toList());

            return  ResponseEntity.ok(estadoReservaResponseDTOS);
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Error al obtener estados de reserva");
        }
    }
}
