package com.finki.AdventureTravel.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TripDto {

    private Long id;

    private String category;

    private String region;

    private String country;

    private String title;

    private BigDecimal price;

    private Integer rating;

    private String tags;

    private Date departureDate;

    private Date endDateToSign;
}
