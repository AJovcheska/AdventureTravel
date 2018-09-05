package com.finki.AdventureTravel.controller;

import com.finki.AdventureTravel.adapter.TripService;
import com.finki.AdventureTravel.model.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TripControllerImpl implements TripController {

    private final TripService tripService;

    @Override
    public ResponseEntity<List<Trip>> getTrips() {
        return ResponseEntity.ok(tripService.getAll());
    }

    @Override
    public ResponseEntity<List<Trip>> getTripsByCategory(@PathVariable(name = "category") String category) {
        return ResponseEntity.ok(tripService.getByCategory(category));
    }

    @Override
    public ResponseEntity<List<Trip>> getTripsByCountry(@PathVariable(name = "country") String country) {
        return ResponseEntity.ok(tripService.getByCountry(country));
    }

    @Override
    public ResponseEntity<List<Trip>> getTripsByRegion(@PathVariable(name = "region") String region) {
        return ResponseEntity.ok(tripService.getByRegion(region));
    }
}
