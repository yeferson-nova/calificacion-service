package com.ynova.msvc.calificacion.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, String> {

    @Override
    public String convert(ZonedDateTime source) {
        return source.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
}
