package com.example.ExamenSpringBoot.controllers;

import com.example.ExamenSpringBoot.dto.EspacioRequestDTO;
import com.example.ExamenSpringBoot.services.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;

@RestController
@RequestMapping("/espacios")
public class EspacioController {
    @Autowired
    private EspacioService espacioService;

    @GetMapping
    public ResponseEntity<?> obtenerEspacios(){

        return espacioService.obtenerEspacios();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> obtenerEspacio(@PathVariable Integer id){

        return espacioService.obtenerPorId(id);
    }

    @GetMapping("/filtrados")
    public ResponseEntity<?> obtenerEspaciosFiltrados(@RequestParam(name = "fecha") Date fecha, @RequestParam("horainicio")Time horainicio, @RequestParam("horafin")Time horafin, @RequestParam("tipo") String tipo){
        return espacioService.obtenerEspaciosFiltrados(fecha, horainicio, horafin, tipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEspacio(@PathVariable Integer id){
        if(espacioService.eliminarEspacio(id)){
            return ResponseEntity.ok("Espacio eliminado correctamente");
        } else{
            return ResponseEntity.badRequest().body("Error al eliminar espacio");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEspacio(@RequestBody EspacioRequestDTO espacioRequestDTO, @PathVariable Integer id){
        if(espacioService.actualizarEspacio(espacioRequestDTO, id)){
            return ResponseEntity.ok("Espacio actualizado correctamente");
        } else{
            return ResponseEntity.badRequest().body("Error al actualizar espacio");
        }
    }

    @PostMapping
    public ResponseEntity<String> crearEspacio(@RequestBody EspacioRequestDTO espacioRequestDTO){
        System.out.println(espacioRequestDTO);
        if(espacioService.crearEspacio(espacioRequestDTO)){
            return ResponseEntity.ok("Espacio creado correctamente");
        } else{
            return ResponseEntity.badRequest().body("Error al crear espacio");
        }
    }
}
