package app.service.place;

import app.model.Place;

import java.util.List;

public interface PlaceDAO {
    public List<Place> findAll();
    public Place findById(Integer placeId);
    public void inserNew(Place p);
    public void updatePlace(Place p);
    public void deletePlace(Integer placeId);
}
