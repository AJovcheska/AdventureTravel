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
    TripDto findById(String title);

    @Transactional(readOnly = true)
    List<TripDto> findSelectedTrips(List<String> regions, List<String> categories, String sortBy, boolean ascending);

    @Transactional(readOnly = true)
    List<TripDto> findTripsForUser(String user);

}
