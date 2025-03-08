package com.ynova.msvc.calificacion.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "calificaciones")
public class Calificacion {

    @Id
    private String id;
    private Long usuarioId;
    private Long hotelId;
    @JsonProperty("calificacion")
    @Field("calificacion")
    private int puntuacion;
    private String comentario;

}
