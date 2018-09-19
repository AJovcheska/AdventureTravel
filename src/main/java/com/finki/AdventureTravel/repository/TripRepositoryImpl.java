package com.finki.AdventureTravel.repository;

import com.finki.AdventureTravel.queries.TripQueries;
import com.finki.AdventureTravel.mapper.TripMapper;
import com.finki.AdventureTravel.model.TripDto;
import com.finki.AdventureTravel.util.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TripRepositoryImpl implements TripRepository {

    private TripQueries tripQueries;
    private QueryBuilder queryBuilder;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TripRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, TripQueries tripQueries, QueryBuilder queryBuilder) {
        this.jdbcTemplate = jdbcTemplate;
        this.tripQueries = tripQueries;
        this.queryBuilder = queryBuilder;
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
    public List<TripDto> findSelectedTrips(List<String> countries, List<String> categories) {
        String selectAll = tripQueries.getSelectAll();
        StringBuilder sb = new StringBuilder();
        if (isNullOrEmpty(countries) && isNullOrEmpty(categories)) {
            return jdbcTemplate.query(selectAll, new TripMapper());
        } else {
            sb.append(" where ");
            if (isNullOrEmpty(categories)) {
                sb.append(queryBuilder.addCountries(countries));
            } else if (isNullOrEmpty(countries)) {
                sb.append(queryBuilder.addCategories(categories));
            } else {
                sb.append(queryBuilder.addCategories(categories));
                sb.append(" and ");
                sb.append(queryBuilder.addCountries(countries));
            }
            selectAll += sb.toString();
            return jdbcTemplate.query(selectAll, new TripMapper());
        }
    }

    private boolean isNullOrEmpty(List<String> list) {
        return list == null || list.isEmpty();
    }

}
