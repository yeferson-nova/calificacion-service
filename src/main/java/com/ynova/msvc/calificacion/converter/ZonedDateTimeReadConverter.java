package com.ynova.msvc.calificacion.converter;

import org.springframework.core.convert.converter.Converter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeReadConverter implements Converter<String, ZonedDateTime> {

    @Override
    public ZonedDateTime convert(String source) {
        return ZonedDateTime.parse(source, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
}
