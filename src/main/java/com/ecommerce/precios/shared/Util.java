package com.ecommerce.precios.shared;

import com.ecommerce.precios.infrastructure.exception.BadRequestException;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Util {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime transformLocalDateTime(String dateRequest) {
        try {
            return LocalDateTime.parse(dateRequest, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Fecha no válida: " + dateRequest);
        }
    }
}
