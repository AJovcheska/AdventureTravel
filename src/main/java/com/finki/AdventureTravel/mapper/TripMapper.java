package com.finki.AdventureTravel.mapper;

import com.finki.AdventureTravel.model.TripDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripMapper implements RowMapper<TripDto> {

    @Override
    public TripDto mapRow(ResultSet resultSet, int i) throws SQLException {
        TripDto trip = new TripDto();
        trip.setId(resultSet.getLong("id"));
        trip.setCategory(resultSet.getString("category"));
        trip.setRegion(resultSet.getString("region"));
        trip.setCountry(resultSet.getString("country"));
        trip.setTitle(resultSet.getString("title"));
        trip.setBeenHere(resultSet.getInt("been_here"));
        trip.setWantToVisit(resultSet.getInt("want_to_visit"));
        trip.setStars(resultSet.getInt("stars"));
        trip.setPrice(resultSet.getBigDecimal("price"));
        trip.setDepartureDate(resultSet.getDate("departure_date"));
        trip.setEndDateToSign(resultSet.getDate("end_date_to_sign"));
        trip.setDescription(resultSet.getString("description"));
        return trip;
    }
}