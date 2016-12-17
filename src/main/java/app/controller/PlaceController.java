package app.controller;

import app.model.Place;
import app.service.place.PlaceDAO;
import app.service.place.PlaceDAOJdbc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PlaceController {
    PlaceDAO placeDAO;

    public PlaceController() { placeDAO = new PlaceDAOJdbc(); }

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> allPlaces() {
        return placeDAO.findAll();
    }

    @RequestMapping(value = "/places/{placeId}", method = RequestMethod.GET)
    public Place getPlaceInfo(@PathVariable Integer placeId) {
        Place p = placeDAO.findById(placeId);
        return p;
    }

    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public void createPlace(
            @RequestBody Place place
    ) {
        placeDAO.inserNew(new Place(0, place.getPlacename()));
    }

    @RequestMapping(value = "/places/{placesId}", method = RequestMethod.PUT)
    public void updatePlace(
            @RequestBody Place place,
            @PathVariable Integer placeId
    ) {
        Place p = placeDAO.findById(placeId);
        p.setPlacename(place.getPlacename());
        placeDAO.updatePlace(p);
    }

    @RequestMapping(value = "/places/{placeId}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable Integer placeId) {
        placeDAO.deletePlace(placeId);
    }
}
