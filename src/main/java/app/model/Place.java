package app.model;

import lombok.Data;

@Data
public class Place {
    Integer placeID;
    String placeName;

    @Override
    public String toString() {
        return placeName;
    }
}
