package com.finki.AdventureTravel.repository;

import com.finki.AdventureTravel.mapper.UserMapper;
import com.finki.AdventureTravel.model.User;
import com.finki.AdventureTravel.queries.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private UserQueries userQueries;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(UserQueries userQueries, NamedParameterJdbcTemplate jdbcTemplate) {
        this.userQueries = userQueries;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", user.getName());
        map.addValue("age", user.getAge());
        map.addValue("password", user.getPassword());
        map.addValue("country", user.getCountry());
        map.addValue("email", user.getEmail());
        map.addValue("sex", user.getSex());
        map.addValue("profession", user.getProfession());
        map.addValue("trip_companion", user.getTripCompanion());
        map.addValue("entertainment", user.getEntertainment());
        map.addValue("trip_length", user.getTripLength());
        map.addValue("destination", user.getDestination());
        jdbcTemplate.update(userQueries.getAddUser(), map);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(userQueries.getSelectAll(), new UserMapper());
    }

    @Override
    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject(userQueries.getSelectByUsername(),
                new MapSqlParameterSource("email", email), new UserMapper());
    }


}
