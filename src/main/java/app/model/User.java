package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Dudix on 2016-12-01.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer userid;
    String name;

    @Override
    public String toString() {
        return "User (id: " + userid +
                "), name: " + name;
    }
}
