package com.finki.AdventureTravel.mapper;

import com.finki.AdventureTravel.model.Category;
import com.finki.AdventureTravel.model.Trip;
import com.finki.AdventureTravel.model.TripDto;

public final class TripDtoToTripMapper {

    public static Trip mapDtoToTrip(TripDto tripDto) {
        Trip trip = new Trip();
        trip.setId(tripDto.getId());
        trip.setCategory(Category.valueOf(tripDto.getCategory()));
        trip.setRegion(tripDto.getRegion());
        trip.setCountry(tripDto.getCountry());
        trip.setTitle(tripDto.getTitle());
        trip.setStars(tripDto.getStars());
        trip.setDescription(tripDto.getDescription());
        trip.setDepartureDate(tripDto.getDepartureDate());
        trip.setEndDateToSign(tripDto.getEndDateToSign());
        trip.setBeenHere(tripDto.getBeenHere());
        trip.setWantToVisit(tripDto.getWantToVisit());
        trip.setPrice(tripDto.getPrice());
        return trip;
    }
}
