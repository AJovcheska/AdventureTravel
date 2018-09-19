package com.finki.AdventureTravel.mapper;

import com.finki.AdventureTravel.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setPassword(resultSet.getString("password"));
        user.setCountry(resultSet.getString("country"));
        user.setEmail(resultSet.getString("email"));
        user.setSex(resultSet.getString("sex"));
        user.setProfession(resultSet.getString("profession"));
        return user;
    }
}
