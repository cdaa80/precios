package com.ecommerce.precios.application.service;

import com.ecommerce.precios.domain.model.Price;
import com.ecommerce.precios.domain.repository.PriceRepository;
import com.ecommerce.precios.infrastructure.exception.NotFoundException;
import com.ecommerce.precios.shared.Util;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Comparator;
@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository repository;

    public Price search(String dateRequest, String product, String brand) {


        Collection<Price> response = repository.findPriceByProductIdAndBrandIdAndStartDate(product, brand, Util.transformLocalDateTime(dateRequest));


        return response.stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> new NotFoundException("No existe información con los parámetros de búsqueda: "
                        + "Fecha: " + dateRequest + ", Producto: " + product + ", Marca: " + brand));
    }
}
