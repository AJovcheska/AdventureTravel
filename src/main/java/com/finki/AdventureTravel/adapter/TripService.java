package com.finki.AdventureTravel.adapter;

import com.finki.AdventureTravel.mapper.TripDtoToTripMapper;
import com.finki.AdventureTravel.model.Trip;
import com.finki.AdventureTravel.model.TripDto;
import com.finki.AdventureTravel.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public List<Trip> getAll() {
        return mapTripDtoListToTripList(tripRepository.findAll());
    }

    public List<Trip> getByCategory(String category) {
        return mapTripDtoListToTripList(tripRepository.findByCategory(category));
    }

    public List<Trip> getByRegion(String region) {
        return mapTripDtoListToTripList(tripRepository.findByRegion(region));
    }

    private List<Trip> mapTripDtoListToTripList(List<TripDto> tripDtos) {
        List<Trip> trips = Lists.newArrayList();
        for (TripDto tripDto : tripDtos) {
            trips.add(TripDtoToTripMapper.mapDtoToTrip(tripDto));
        }
        return trips;
    }

    public List<Trip> getSelectedTrips(List<String> countries, List<String> categories) {
        return mapTripDtoListToTripList(tripRepository.findSelectedTrips(countries, categories));
    }
}
