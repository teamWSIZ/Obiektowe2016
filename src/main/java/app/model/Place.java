package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    Integer placeid;
    String placename;

    @Override
    public String toString() {
        return placename;
    }
}
