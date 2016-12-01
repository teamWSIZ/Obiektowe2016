package app.model;

import lombok.Data;

import java.util.Date;

@Data
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
