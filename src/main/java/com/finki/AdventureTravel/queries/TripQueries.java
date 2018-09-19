package com.finki.AdventureTravel.queries;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("classpath:trip-queries.properties")
public class TripQueries {

    @Value("${select-all-trips}")
    private String selectAll;

    @Value("${select-by-region}")
    private String selectByRegion;

    @Value("${select-by-category}")
    private String selectByCategory;
}


