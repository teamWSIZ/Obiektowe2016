package app.service.Break;

import app.model.Break;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BreakMapper implements RowMapper<Break> {
    @Override
    public Break mapRow(ResultSet resultSet, int i) throws SQLException {
        Break b = new Break();
        b.setBreakid(resultSet.getInt("breakId"));
        b.setName(resultSet.getString("name"));
        return b;
    }
}
