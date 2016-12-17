package app.service.place;

import app.model.Place;
import app.service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PlaceDAOJdbc implements PlaceDAO {
    JdbcTemplate template = new JdbcTemplate();

    public PlaceDAOJdbc() { this.template = JdbcTemplateFactory.getTemplate(); }

    @Override
    public List<Place> findAll() {
        return template.query("select * from places", new PlaceMapper());
    }

    @Override
    public Place findById(Integer placeId) {
        return template.queryForObject(
                "select * from places where placeid=(?)",
                new Object[]{placeId}, new PlaceMapper());
    }

    @Override
    public void inserNew(Place p) {
        template.update("insert into places (placename) values (?)",
                p.getPlaceName());
    }

    @Override
    public void updatePlace(Place p) {
        template.update("update places set placename=(?) where placeid=(?)",
                p.getPlaceName(), p.getPlaceID());
    }

    @Override
    public void deletePlace(Integer placeId) {
        template.update("delete from places where placeid=(?)", placeId);
    }
}
