package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer userid;
    String username;

    @Override
    public String toString() {
        return "User (id: " + userid +
                "), breakname: " + username;
    }
}
