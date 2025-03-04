package com.ecommerce.precios.domain.repository;

import com.ecommerce.precios.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Collection;


public interface PriceRepository  extends JpaRepository<Price,String> {
    @Query("Select p from Price p where p.productId =:productId and p.brandId =:brandId and :dateRequest >= p.startDate  and :dateRequest <=p.endDate ")
    Collection<Price> findPriceByProductIdAndBrandIdAndStartDate(String productId, String brandId, LocalDateTime dateRequest);
}