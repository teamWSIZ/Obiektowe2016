package app.service.duty;

import app.model.Duty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DutyMapper implements RowMapper<Duty> {
    @Override
    public Duty mapRow(ResultSet resultSet, int i) throws SQLException {
        Duty d = new Duty();
        d.setDutyid(resultSet.getInt("dutyid"));
        d.setUserid(resultSet.getInt("userid"));
        d.setBreakid(resultSet.getInt("breakid"));
        d.setPlaceid(resultSet.getInt("placeid"));
        d.setDate(resultSet.getDate("date"));
        return d;
    }
}
