package com.ynova.msvc.calificacion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ynova.msvc.calificacion.entity.Calificacion;

public interface CalificacionRepository extends MongoRepository<Calificacion, String> {
    List<Calificacion> findByUsuarioId(int usuarioId);

    List<Calificacion> findByHotelId(int hotelId);
}
