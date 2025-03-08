package com.ynova.msvc.calificacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynova.msvc.calificacion.entity.Calificacion;
import com.ynova.msvc.calificacion.repository.CalificacionRepository;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    private CalificacionRepository calificacionRepository;

    @Autowired
    public CalificacionServiceImpl(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public Calificacion createCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> getCalificaciones() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion getCalificacionById(String id) {
        return calificacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Calificacion> getCalificacionesByUsuarioId(int usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotelId(int hotelId) {
        return calificacionRepository.findByHotelId(hotelId);
    }

}
