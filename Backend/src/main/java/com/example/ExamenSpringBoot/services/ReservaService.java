package com.example.ExamenSpringBoot.services;

import com.example.ExamenSpringBoot.dto.ReservaRequestDTO;
import com.example.ExamenSpringBoot.entities.EstadoReserva;
import com.example.ExamenSpringBoot.entities.Reserva;
import com.example.ExamenSpringBoot.repositories.EspacioRepository;
import com.example.ExamenSpringBoot.repositories.EstadoReservaRepository;
import com.example.ExamenSpringBoot.repositories.ReservaRepository;
import com.example.ExamenSpringBoot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    @Autowired
    private EspacioRepository espacioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Boolean crearReserva(ReservaRequestDTO reservaRequestDTO){
        try {
            Reserva reserva = new Reserva();
            reserva.setEstadoReserva(estadoReservaRepository.findByNombre("pendiente").orElseThrow());
            reserva.setEspacio(espacioRepository.findById(reservaRequestDTO.getIdEspacio()).orElseThrow());
            reserva.setUsuario(usuarioRepository.findByDocumento(reservaRequestDTO.getDocumentoUsuario()).orElseThrow());
            reserva.setFecha(reservaRequestDTO.getFecha());
            reserva.setHoraInicio(reservaRequestDTO.getHoraInicio());
            reserva.setHoraFin(reservaRequestDTO.getHoraFin());
            reservaRepository.save(reserva);
            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean actualizarReserva(ReservaRequestDTO reservaRequestDTO, Integer idReserva){
        try {
            Reserva reserva = reservaRepository.findById(idReserva).orElseThrow();
            reserva.setEstadoReserva(estadoReservaRepository.findByNombre("pendiente").orElseThrow());
            reserva.setEspacio(espacioRepository.findById(reservaRequestDTO.getIdEspacio()).orElseThrow());
            reserva.setUsuario(usuarioRepository.findByDocumento(reservaRequestDTO.getDocumentoUsuario()).orElseThrow());
            reserva.setFecha(reservaRequestDTO.getFecha());
            reserva.setHoraInicio(reservaRequestDTO.getHoraInicio());
            reserva.setHoraFin(reservaRequestDTO.getHoraFin());
            reservaRepository.save(reserva);
            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean cancelarReserva( Integer idReserva){
        try {
            Reserva reserva = reservaRepository.findById(idReserva).orElseThrow();
            reserva.setEstadoReserva(estadoReservaRepository.findByNombre("cancelada").orElseThrow());
            reservaRepository.save(reserva);
            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean confirmarReserva( Integer idReserva){
        try {
            Reserva reserva = reservaRepository.findById(idReserva).orElseThrow();
            reserva.setEstadoReserva(estadoReservaRepository.findByNombre("confirmada").orElseThrow());
            reservaRepository.save(reserva);
            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public ResponseEntity<?> obtenerReservasFiltradas(Date fecha, Integer idEstado){
        try{
            List<Reserva> reservas = reservaRepository.findByFechaAndEstadoId(fecha, idEstado);
            return ResponseEntity.ok(reservas);
        } catch (Exception e){
            System.out.println(e);
            return  ResponseEntity.badRequest().body("Error al filtrar reservas");
        }
    }




}
