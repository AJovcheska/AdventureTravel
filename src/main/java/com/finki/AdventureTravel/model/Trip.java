package com.finki.AdventureTravel.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Trip {

    private Long id;

    private Category category;

    private String region;

    private String country;

    private String title;

    private BigDecimal price;

    private Integer rating;

    private Date departureDate;

    private Date endDateToSign;
}
