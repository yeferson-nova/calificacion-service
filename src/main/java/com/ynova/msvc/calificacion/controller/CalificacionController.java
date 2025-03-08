package com.ynova.msvc.calificacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynova.msvc.calificacion.entity.Calificacion;
import com.ynova.msvc.calificacion.service.CalificacionService;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    private CalificacionService calificacionService;

    public CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @PostMapping("/save")
    public ResponseEntity<Calificacion> guardar(@RequestBody Calificacion calificacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.createCalificacion(calificacion));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Calificacion>> listarCalificaciones() {
        return ResponseEntity.ok().body(calificacionService.getCalificaciones());
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionPorUsuarioId(@PathVariable int usuarioId) {
        return ResponseEntity.ok().body(calificacionService.getCalificacionesByUsuarioId(usuarioId));
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionPorHotelId(@PathVariable int hotelId) {
        return ResponseEntity.ok().body(calificacionService.getCalificacionesByHotelId(hotelId));
    }
}
