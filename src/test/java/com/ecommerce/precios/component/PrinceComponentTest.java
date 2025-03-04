package com.ecommerce.precios.component;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PrinceComponentTest {
    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("searchArgumentPrices")
    public void search_ok(String date, String product, String brand, Double price) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/price")
                        .queryParam("dateRequest", date)
                        .queryParam("product", product)
                        .queryParam("brand", brand)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andExpect( content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect( jsonPath("$.price").value(price));

    }

    static Stream<Arguments> searchArgumentPrices() {
        return Stream.of(
                Arguments.of("2020-06-14 10:00:00", "35455", "1",35.50),
                Arguments.of("2020-06-14 16:00:00", "35455", "1",25.45),
                Arguments.of("2020-06-14 21:00:00", "35455", "1",35.50),
                Arguments.of("2020-06-15 10:00:00", "35455", "1",30.50),
                Arguments.of("2020-06-16 21:00:00", "35455", "1",38.95)
        );
    }
}
