package com.ynova.msvc.calificacion.service;

import java.util.List;

import com.ynova.msvc.calificacion.entity.Calificacion;

public interface CalificacionService {

    Calificacion createCalificacion(Calificacion calificacion);

    List<Calificacion> getCalificaciones();

    Calificacion getCalificacionById(String id);

    List<Calificacion> getCalificacionesByUsuarioId(int usuarioId);

    List<Calificacion> getCalificacionesByHotelId(int hotelId);
}
