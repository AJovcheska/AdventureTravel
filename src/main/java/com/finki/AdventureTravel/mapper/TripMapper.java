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
        trip.setRating(resultSet.getInt("rating"));
        trip.setPrice(resultSet.getBigDecimal("price"));
        trip.setDepartureDate(resultSet.getDate("departure_date"));
        trip.setEndDateToSign(resultSet.getDate("end_date_to_sign"));
        return trip;
    }
}
