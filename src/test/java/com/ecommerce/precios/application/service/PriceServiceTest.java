package com.ecommerce.precios.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.List;
import com.ecommerce.precios.domain.model.Price;
import com.ecommerce.precios.domain.repository.PriceRepository;
import com.ecommerce.precios.infrastructure.exception.NotFoundException;
import com.ecommerce.precios.shared.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;



    @Test
    void testSearch_ok() {

        String dateRequest = "2025-03-04 12:00:00";
        String product = "2222";
        String brand = "1";

        LocalDateTime dateTime = Util.transformLocalDateTime(dateRequest);

        Price price1 = new Price("1", brand, dateTime.minusDays(1), dateTime.plusDays(1), "1001", product, 0, 50.0, "EUR");
        Price price2 = new Price("2", brand, dateTime.minusDays(2), dateTime.plusDays(2), "1002", product, 1, 60.0, "EUR");

        when(priceRepository.findPriceByProductIdAndBrandIdAndStartDate(product, brand, dateTime))
                .thenReturn(List.of(price1, price2));


        Price result = priceService.search(dateRequest, product, brand);


        assertNotNull(result);
        assertEquals("2", result.getId());
    }

    @Test
    void testSearch_NotFound() {

        String dateRequest = "2020-06-14 10:00:00";
        String product = "99999";
        String brand = "5";

        LocalDateTime dateTime = Util.transformLocalDateTime(dateRequest);

        when(priceRepository.findPriceByProductIdAndBrandIdAndStartDate(product, brand, dateTime))
                .thenReturn(List.of());

        NotFoundException thrown = assertThrows(NotFoundException.class, () ->
                priceService.search(dateRequest, product, brand)
        );

        assertTrue(thrown.getMessage().contains("No existe información"));
    }
}
