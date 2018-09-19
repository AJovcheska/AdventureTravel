package com.finki.AdventureTravel.controller;

import com.finki.AdventureTravel.adapter.TripService;
import com.finki.AdventureTravel.model.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Trip>> getTripsByRegion(@PathVariable(name = "region") String region) {
        return ResponseEntity.ok(tripService.getByRegion(region));
    }

    @Override
    public ResponseEntity<List<Trip>> getSelectedTrips(@RequestParam(name = "country", required = false) List<String> countries,
                                                       @RequestParam(name = "category", required = false) List<String> categories,
                                                       @RequestParam(name = "sortBy") String sortBy,
                                                       @RequestParam(name = "ascending") boolean ascending) {
        return ResponseEntity.ok(tripService.getSelectedTrips(countries, categories, sortBy, ascending));
    }
}

