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
        this.jdbcTemplate = jdbcTemplate;
        this.userQueries = userQueries;
    }

    @Override
    public void addUser(User user) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("username", user.getUsername());
        map.addValue("name", user.getName());
        map.addValue("age", user.getAge());
        map.addValue("password", user.getPassword());
        map.addValue("country", user.getCountry());
        map.addValue("email", user.getEmail());
        map.addValue("sex", user.getSex());
        map.addValue("profession", user.getProfession());
        jdbcTemplate.update(userQueries.getAddUser(), map);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(userQueries.getSelectAll(), new UserMapper());
    }

    @Override
    public User findByUsername(String username) {
        return jdbcTemplate.queryForObject(userQueries.getSelectByUsername(),
                new MapSqlParameterSource("username", username), new UserMapper());
    }


}
