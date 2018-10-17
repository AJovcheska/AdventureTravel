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

    public List<Trip> findTripsForUser(String user) {
        return mapTripDtoListToTripList(tripRepository.findTripsForUser(user));
    }

    public Trip getTripById(String id) {
        return TripDtoToTripMapper.mapDtoToTrip(tripRepository.findById(id));
    }

    private List<Trip> mapTripDtoListToTripList(List<TripDto> tripDtos) {
        List<Trip> trips = Lists.newArrayList();
        for (TripDto tripDto : tripDtos) {
            trips.add(TripDtoToTripMapper.mapDtoToTrip(tripDto));
        }
        return trips;
    }

    public List<Trip> getSelectedTrips(List<String> regions, List<String> categories, String sortBy, boolean ascending) {
        return mapTripDtoListToTripList(tripRepository.findSelectedTrips(regions, categories, sortBy, ascending));
    }

    public List<Trip> getByTag(String tag) {
        List<Trip> trips = mapTripDtoListToTripList(tripRepository.findAll());

        List<Trip> tripsByTag = Lists.newArrayList();
        for (Trip trip : trips) {
            if (trip.getTags().contains(tag)) {
                tripsByTag.add(trip);
            }
        }
        return tripsByTag;
    }
}
