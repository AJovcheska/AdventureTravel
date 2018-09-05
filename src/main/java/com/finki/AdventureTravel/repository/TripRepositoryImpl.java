package com.finki.AdventureTravel.repository;

import com.finki.AdventureTravel.queries.TripQueries;
import com.finki.AdventureTravel.mapper.TripMapper;
import com.finki.AdventureTravel.model.TripDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TripRepositoryImpl implements TripRepository {

    private TripQueries tripQueries;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TripRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, TripQueries tripQueries) {
        this.jdbcTemplate = jdbcTemplate;
        this.tripQueries = tripQueries;
    }

    @Override
    public List<TripDto> findAll() {
        return jdbcTemplate.query(tripQueries.getSelectAll(), new TripMapper());
    }

    @Override
    public List<TripDto> findByCategory(String category) {
        return jdbcTemplate.query(tripQueries.getSelectByCategory(),
                new MapSqlParameterSource("category", category), new TripMapper());
    }

    @Override
    public List<TripDto> findByRegion(String region) {
        return jdbcTemplate.query(tripQueries.getSelectByRegion(),
                new MapSqlParameterSource("region", region), new TripMapper());
    }

    @Override
    public List<TripDto> findByCountry(String country) {
        return jdbcTemplate.query(tripQueries.getSelectByCountry(),
                new MapSqlParameterSource("country", country), new TripMapper());
    }

}
