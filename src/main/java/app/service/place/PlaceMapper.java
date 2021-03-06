package app.service.place;

import app.model.Place;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceMapper implements RowMapper<Place>{
    @Override
    public Place mapRow(ResultSet resultSet, int i) throws SQLException {
        Place p = new Place();
        p.setPlaceid(resultSet.getInt("placeid"));
        p.setPlacename(resultSet.getString("placename"));
        return p;
    }
}
