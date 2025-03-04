package com.ecommerce.precios.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@Table(name="prices")
public class Price implements Serializable {
    @Id
    private String id;

    @Column(name ="brand_id")
    private String brandId;

    @Column (name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;


    @Column(name ="price_list")
    private String priceList;

    @Column(name ="product_id")
    private String productId;

    private int priority;

    private Double price;

    private String curr;

    public Price(String id, String brandId, LocalDateTime startDate, LocalDateTime endDate, String priceList, String productId, int priority, Double price, String curr) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }
}
