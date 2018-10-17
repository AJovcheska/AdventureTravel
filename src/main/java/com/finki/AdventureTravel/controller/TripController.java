package com.finki.AdventureTravel.controller;

import com.finki.AdventureTravel.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public interface TripController {

    @GetMapping(value = "/trips")
    ResponseEntity<List<Trip>> getTrips();

    @GetMapping(value = "/trips/category/{category}")
    ResponseEntity<List<Trip>> getTripsByCategory(@PathVariable(name = "category") String category);

    @GetMapping(value = "/trips/region/{region}")
    ResponseEntity<List<Trip>> getTripsByRegion(@PathVariable(name = "region") String region);

    @GetMapping(value = "/trips/id")
    ResponseEntity<Trip> getTripById(@RequestParam(name = "id") String id);

    @GetMapping(value = "/trips/selected")
    ResponseEntity<List<Trip>> getSelectedTrips(@RequestParam(name = "region", required = false) List<String> regions,
                                                @RequestParam(name = "category", required = false) List<String> categories,
                                                @RequestParam(name = "sortBy") String sortBy,
                                                @RequestParam(name = "ascending") boolean ascending);

    @GetMapping(value = "/user/trips")
    ResponseEntity<List<Trip>> getTripsForUser(@PathVariable String user);

    @GetMapping(value = "/trips/tag")
    ResponseEntity<List<Trip>> getTripsByTag(@RequestParam(name = "tag") String tag);
}
