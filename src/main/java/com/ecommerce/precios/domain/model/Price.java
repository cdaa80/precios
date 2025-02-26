package com.ecommerce.precios.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity
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
}
