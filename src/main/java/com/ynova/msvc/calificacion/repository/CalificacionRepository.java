package com.ynova.msvc.calificacion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ynova.msvc.calificacion.entity.Calificacion;

public interface CalificacionRepository extends MongoRepository<Calificacion, String> {
    List<Calificacion> findByUsuarioId(String usuarioId);

    List<Calificacion> findByHotelId(String hotelId);
}
