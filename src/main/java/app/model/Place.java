package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    Integer placeID;
    String placeName;

    @Override
    public String toString() {
        return placeName;
    }
}
