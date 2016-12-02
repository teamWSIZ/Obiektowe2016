package app.service;


import app.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Zamienia wyniki zapytania na bazie na konkretne instancje klasy Book
 */


public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();
        u.setUserid(rs.getInt("userid"));
        u.setName(rs.getString("name"));
        return u;
    }
}
