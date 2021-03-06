package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Break {
    Integer breakid;
    String breakname;

    @Override
    public String toString() {
        return "Break: id " + breakid + ", breakname: " + breakname;
    }
}
