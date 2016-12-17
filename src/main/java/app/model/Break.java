package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Break {
    Integer breakid;
    String name;

    @Override
    public String toString() {
        return "Break: id " + breakid + ", name: " + name;
    }
}
