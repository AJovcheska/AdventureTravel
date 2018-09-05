package com.finki.AdventureTravel.repository;

import com.finki.AdventureTravel.model.TripDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TripRepository {

    @Transactional(readOnly = true)
    List<TripDto> findAll();

    @Transactional(readOnly = true)
    List<TripDto> findByCategory(String category);

    @Transactional(readOnly = true)
    List<TripDto> findByRegion(String region);

    @Transactional(readOnly = true)
    List<TripDto> findByCountry(String country);

}
