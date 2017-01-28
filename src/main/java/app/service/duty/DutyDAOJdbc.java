package app.service.duty;

import app.model.Duty;
import app.service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class DutyDAOJdbc implements DutyDao {
    JdbcTemplate template;

    public DutyDAOJdbc() { this.template = JdbcTemplateFactory.getTemplate(); }

    @Override
    public List<Duty> findAll() {
        return template.query("select * from duty", new DutyMapper());
    }



    @Override
    public Duty findById(Integer dutyId) {
        return template.queryForObject(
                "select * from duty where dutyid=(?)",
                new Object[]{dutyId}, new DutyMapper());
    }

    //todo: to ma działać!
    @Override
    public List<Duty> findByDate(Date date) {
//        return template.queryForList("select * from duty where date=(?)",
//                new Object[]{date}, new DutyMapper());
        return null;
    }

    @Override
    public void inserNew(Duty d) {
        template.update("insert into duty (userid, breakid, placeid, date) values (?,?,?,?)",
                d.getUserid(), d.getBreakid(), d.getPlaceid(), d.getDate());
    }

    @Override
    public void updateDuty(Duty d) {
        template.update("update duty " +
                "set userid=(?), breakid=(?), placeid=(?), date=(?) where dutyid=(?)",
                d.getUserid(), d.getBreakid(), d.getPlaceid(), d.getDate(), d.getDutyid());
    }

    @Override
    public void deleteDuty(Integer dutyId) {
        template.update("delete from duty where dutyid=(?)", dutyId);
    }
}
