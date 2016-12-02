package app;

import app.model.Place;
import app.service.place.PlaceDAO;
import app.service.place.PlaceDAOJdbc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.management.counter.perf.PerfLongArrayCounter;

import java.util.List;

public class PlaceController {
    PlaceDAO placeDAO;

    public PlaceController() { placeDAO = new PlaceDAOJdbc(); }

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> allPlaces() { return placeDAO.findAll(); }

    @RequestMapping(value = "/places/{placeId}", method = RequestMethod.GET)
    public Place getPlaceInfo(@PathVariable Integer placeId) {
        Place p = placeDAO.findById(placeId);
        return p;
    }

    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public void createPlace(
            @RequestParam(value = "placeName", defaultValue = "") String placeName
    ) { placeDAO.inserNew(new Place(0, placeName)); }

    @RequestMapping(value = "/places/{placesId}", method = RequestMethod.PUT)
    public void updatePlace(
            @RequestParam(value = "placeName", defaultValue = "") String placeName,
            @PathVariable Integer placeId
    ) { Place p = placeDAO.findById(placeId);
        p.setPlaceName(placeName);
        placeDAO.updatePlace(p); }

    @RequestMapping(value = "/places/{placeId}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable Integer placeId) {
        placeDAO.deletePlace(placeId    );
    }
}
