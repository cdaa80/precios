package com.ecommerce.precios.infrastructure.controller;

import com.ecommerce.precios.application.dto.PriceResponse;
import com.ecommerce.precios.application.service.PriceService;
import com.ecommerce.precios.domain.model.Price;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService service;

    @Operation(summary = "Get Product Price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/price")
    public ResponseEntity<PriceResponse> search(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String dateRequest,
            @RequestParam String product,
            @RequestParam String brand) {

        Price priceModel = service.search(dateRequest, product, brand);

        PriceResponse response = new PriceResponse(
                priceModel.getProductId(),
                priceModel.getBrandId(),
                priceModel.getPriceList(),
                priceModel.getStartDate(),
                priceModel.getEndDate(),
                priceModel.getPrice()
        );

        return ResponseEntity.ok(response);
    }
}
