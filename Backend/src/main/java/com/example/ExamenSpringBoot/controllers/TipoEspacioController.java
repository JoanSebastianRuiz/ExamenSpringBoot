package com.example.ExamenSpringBoot.controllers;

import com.example.ExamenSpringBoot.services.TipoEspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipos-espacio")
public class TipoEspacioController {
    @Autowired
    private TipoEspacioService tipoEspacioService;

    @GetMapping
    public ResponseEntity<?> obtenerTiposEspacio(){
        return tipoEspacioService.obtenerTipoEspacios();
    }
}
