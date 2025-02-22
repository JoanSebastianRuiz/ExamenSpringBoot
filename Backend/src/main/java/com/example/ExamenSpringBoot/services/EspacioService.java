package com.example.ExamenSpringBoot.services;

import com.example.ExamenSpringBoot.dto.EspacioRequestDTO;
import com.example.ExamenSpringBoot.dto.EspacioResponseDTO;
import com.example.ExamenSpringBoot.entities.Espacio;
import com.example.ExamenSpringBoot.entities.TipoEspacio;
import com.example.ExamenSpringBoot.repositories.EspacioRepository;
import com.example.ExamenSpringBoot.repositories.TipoEspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EspacioService {
    @Autowired
    private EspacioRepository espacioRepository;

    @Autowired
    private TipoEspacioRepository tipoEspacioRepository;

    public Boolean crearEspacio(EspacioRequestDTO espacioRequestDTO){
        try{
            Espacio espacio = new Espacio();
            espacio.setTipoEspacio(tipoEspacioRepository.findById(espacioRequestDTO.getIdTipoEspacio()).orElseThrow());
            espacio.setCapacidad(espacioRequestDTO.getCapacidad());
            espacio.setDisponibilidad(true);
            espacio.setNombre(espacioRequestDTO.getNombre());

            espacioRepository.save(espacio);
            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean eliminarEspacio(Integer idEspacio){
        try{
            Espacio espacio = espacioRepository.findById(idEspacio).orElseThrow();
            espacioRepository.delete(espacio);
            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean actualizarEspacio(EspacioRequestDTO espacioRequestDTO, Integer idEspacio){
        try{
            Espacio espacio = espacioRepository.findById(idEspacio).orElseThrow();
            espacio.setTipoEspacio(tipoEspacioRepository.findById(espacioRequestDTO.getIdTipoEspacio()).orElseThrow());
            espacio.setCapacidad(espacioRequestDTO.getCapacidad());
            espacio.setDisponibilidad(true);
            espacio.setNombre(espacioRequestDTO.getNombre());
            espacioRepository.save(espacio);

            return true;

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public ResponseEntity<?> obtenerEspacios(){
        List<EspacioResponseDTO>  espacioResponseDTOS= new ArrayList<>();
        try{
                List<Espacio> espacios = (List<Espacio>) espacioRepository.findAll();
                espacioResponseDTOS = espacios.stream().map(espacio->{
                    EspacioResponseDTO espacioResponseDTO = new EspacioResponseDTO();
                    espacioResponseDTO.setCapacidad(espacio.getCapacidad());
                    espacioResponseDTO.setDisponibilidad(espacio.getDisponibilidad());
                    espacioResponseDTO.setNombre(espacio.getNombre());
                    espacioResponseDTO.setNombreTipoEspacio(espacio.getTipoEspacio().getNombre());
                    return espacioResponseDTO;
                }).collect(Collectors.toList());

            return ResponseEntity.ok(espacioResponseDTOS);
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Error obteniendo espacios");
        }
    }

    public ResponseEntity<?> obtenerEspaciosFiltrados(Date fecha, Time horainicio, Time horafin, String tipo){
        List<EspacioResponseDTO>  espacioResponseDTOS= new ArrayList<>();
        try{
            TipoEspacio tipoEspacio = tipoEspacioRepository.findByNombre(tipo).orElseThrow();
            List<Espacio> espacios = espacioRepository.findEspaciosDisponiblesPorDisponibilidadYTipo(horainicio, horafin, fecha, tipoEspacio.getId());
            espacioResponseDTOS = espacios.stream().map(espacio->{
                EspacioResponseDTO espacioResponseDTO = new EspacioResponseDTO();
                espacioResponseDTO.setCapacidad(espacio.getCapacidad());
                espacioResponseDTO.setDisponibilidad(espacio.getDisponibilidad());
                espacioResponseDTO.setNombre(espacio.getNombre());
                espacioResponseDTO.setNombreTipoEspacio(espacio.getTipoEspacio().getNombre());
                return espacioResponseDTO;
            }).collect(Collectors.toList());

            return ResponseEntity.ok(espacioResponseDTOS);
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Error obteniendo espacios filtrados");
        }
    }
}
