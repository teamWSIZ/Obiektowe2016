package app.service.duty;

import app.model.Duty;
import app.service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DutyDAOJdbc implements DutyDao {
    JdbcTemplate template;

    public DutyDAOJdbc() { this.template = JdbcTemplateFactory.getTemplate(); }

    @Override
    public List<Duty> findAll() {
        return template.query("select * from duties", new DutyMapper());
    }

    @Override
    public Duty findById(Integer dutyId) {
        return template.queryForObject(
                "select * from duties where dutyid=(?)",
                new Object[]{dutyId}, new DutyMapper());
    }

    @Override
    public void inserNew(Duty d) {
        template.update("insert into duties (userid, breakid, placeid, date) values (?,?,?,?)",
                d.getUserID(), d.getBreakID(), d.getPlaceID(), d.getDate());
    }

    @Override
    public void updateDuty(Duty d) {
        template.update("update duties " +
                "set userid=(?), breakid=(?), placeid=(?), date=(?) where dutyid=(?)",
                d.getUserID(), d.getBreakID(), d.getPlaceID(), d.getDate(), d.getDutyID());
    }

    @Override
    public void deleteDuty(Integer dutyId) {
        template.update("delete from duties where dutyid=(?)", dutyId);
    }
}
