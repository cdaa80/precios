package com.ecommerce.precios.application.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.time.LocalDateTime;

public record PriceResponse(
        String productId,
        String brandId,
        String priceList,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime startDate,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime endDate,
        Double price
) implements Serializable {
}