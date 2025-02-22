package com.example.ExamenSpringBoot.controllers;

import com.example.ExamenSpringBoot.services.EstadoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados-reserva")
public class EstadoReservaController {
    @Autowired
    private EstadoReservaService estadoReservaService;

    @GetMapping
    public ResponseEntity<?> obtenerEstadosReserva(){
        return estadoReservaService.obtenerEstadosReserva();
    }
}
