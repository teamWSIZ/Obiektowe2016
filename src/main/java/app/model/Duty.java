package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duty {
    Integer dutyID;
    Integer userID;
    Integer breakID;
    Integer placeID;
    Date date;

    @Override
    public String toString() {
        return "Duty (id: " + dutyID +
                "), user: " + userID +
                ", Break: " + breakID +
                ", place: " + placeID +
                ", date: " + date;
    }
}
