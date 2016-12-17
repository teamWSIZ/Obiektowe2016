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
        return template.query("select * from place", new PlaceMapper());
    }

    @Override
    public Place findById(Integer placeId) {
        return template.queryForObject(
                "select * from place where placeid=(?)",
                new Object[]{placeId}, new PlaceMapper());
    }

    @Override
    public void inserNew(Place p) {
        template.update("insert into place (placename) values (?)",
                p.getPlacename());
    }

    @Override
    public void updatePlace(Place p) {
        template.update("update place set placename=(?) where placeid=(?)",
                p.getPlacename(), p.getPlaceid());
    }

    @Override
    public void deletePlace(Integer placeId) {
        template.update("delete from place where placeid=(?)", placeId);
    }
}
