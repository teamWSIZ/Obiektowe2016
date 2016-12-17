package app.service.duty;

import app.model.Duty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DutyMapper implements RowMapper<Duty> {
    @Override
    public Duty mapRow(ResultSet resultSet, int i) throws SQLException {
        Duty d = new Duty();
        d.setDutyID(resultSet.getInt("dutyId"));
        d.setUserID(resultSet.getInt("userId"));
        d.setBreakID(resultSet.getInt("breakid"));
        d.setPlaceID(resultSet.getInt("placeID"));
        d.setDate(resultSet.getDate("date"));
        return null;
    }
}
