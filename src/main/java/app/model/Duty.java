package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duty {
    Integer dutyid;
    Integer userid;
    Integer breakid;
    Integer placeid;
    Date date;

    @Override
    public String toString() {
        return "Duty (id: " + dutyid +
                "), user: " + userid +
                ", Break: " + breakid +
                ", place: " + placeid +
                ", date: " + date;
    }
}
