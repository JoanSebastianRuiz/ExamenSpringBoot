package com.example.ExamenSpringBoot.controllers;

import com.example.ExamenSpringBoot.dto.ReservaRequestDTO;
import com.example.ExamenSpringBoot.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<String> crearReserva(@RequestBody ReservaRequestDTO reservaRequestDTO){
        if(reservaService.crearReserva(reservaRequestDTO)){
            return ResponseEntity.ok("Reserva creada correctamente");
        } else {
            return ResponseEntity.badRequest().body("Error al crear reserva");
        }
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<String> cancelarReserva(@PathVariable Integer id){
        if(reservaService.cancelarReserva(id)){
            return ResponseEntity.ok("Reserva cancelada correctamente");
        } else {
            return ResponseEntity.badRequest().body("Error al cancelar reserva");
        }
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<String> confirmarReserva(@PathVariable Integer id){
        if(reservaService.confirmarReserva(id)){
            return ResponseEntity.ok("Reserva confirmada correctamente");
        } else {
            return ResponseEntity.badRequest().body("Error al confirmar reserva");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarReserva(@RequestBody ReservaRequestDTO reservaRequestDTO, @PathVariable Integer id){
        if(reservaService.actualizarReserva(reservaRequestDTO, id)){
            return ResponseEntity.ok("Reserva actualizada correctamente");
        } else {
            return ResponseEntity.badRequest().body("Error al actualizar reserva");
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerReservasFiltradas(@RequestParam(name = "fecha")Date fecha, @RequestParam(name = "idestado") Integer idestado){
        return reservaService.obtenerReservasFiltradas(fecha, idestado);
    }
}
