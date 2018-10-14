package com.finki.AdventureTravel.repository;

import com.finki.AdventureTravel.queries.TripQueries;
import com.finki.AdventureTravel.mapper.TripMapper;
import com.finki.AdventureTravel.model.TripDto;
import com.finki.AdventureTravel.util.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
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
    public TripDto findById(String id) {
        return jdbcTemplate.queryForObject(tripQueries.getSelectById(),
                new MapSqlParameterSource("id", id), new TripMapper());
    }

    @Override
    public List<TripDto> findTripsForUser(String user) {
        return jdbcTemplate.query(tripQueries.getSelectTripsForUser(),
                new MapSqlParameterSource("user", user), new TripMapper());

    }

    @Override
    public List<TripDto> findSelectedTrips(List<String> regions, List<String> categories, String sortBy, boolean ascending) {
        String selectAll = tripQueries.getSelectAll();
        StringBuilder sb = new StringBuilder();
        if (!isNullOrEmpty(regions) || !isNullOrEmpty(categories)) {
            sb.append(" where ");
            if (isNullOrEmpty(categories)) {
                sb.append(queryBuilder.addRegions(regions));
            } else if (isNullOrEmpty(regions)) {
                sb.append(queryBuilder.addCategories(categories));
            } else {
                sb.append(queryBuilder.addCategories(categories));
                sb.append(" and ");
                sb.append(queryBuilder.addRegions(regions));
            }
        }

        sb.append(" order by ");
        sb.append(sortBy);
        if (ascending) {
            sb.append(" asc ");
        } else {
            sb.append(" desc ");
        }

        selectAll += sb.toString();
        return jdbcTemplate.query(selectAll, new TripMapper());
    }

    private boolean isNullOrEmpty(List<String> list) {
        return list == null || list.isEmpty();
    }

}
