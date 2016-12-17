package app.service.user;

import app.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User u = new User();
        u.setUserid(resultSet.getInt("userid"));
        u.setName(resultSet.getString("name"));
        return u;
    }
}
