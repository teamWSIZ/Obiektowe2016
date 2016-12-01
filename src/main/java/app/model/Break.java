package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Break {
    Integer breakID;
    String breakName;

    @Override
    public String toString() {
        return "Break: id " + breakID + ", name: " + breakName;
    }
}
