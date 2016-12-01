package app.model;

import lombok.Data;

@Data
public class Break {
    Integer breakID;
    String breakName;

    @Override
    public String toString() {
        return "Break: id " + breakID + ", name: " + breakName;
    }
}
