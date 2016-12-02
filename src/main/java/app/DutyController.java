package app;

import app.model.Duty;
import app.service.duty.DutyDAOJdbc;
import app.service.duty.DutyDao;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class DutyController {
    DutyDao dutyDao;

    public DutyController() { dutyDao = new DutyDAOJdbc(); }

    @RequestMapping(value = "/duties", method = RequestMethod.GET)
    public List<Duty> allDuties() { return dutyDao.findAll(); }

    @RequestMapping(value = "/duties/{dutyId}", method = RequestMethod.GET)
    public Duty getDutyInfo(@PathVariable Integer dutyId) {
        Duty d = dutyDao.findById(dutyId);
        return d;
    }

    @RequestMapping(value = "/duties", method = RequestMethod.POST)
    public void createDuty(
            @RequestBody Duty duty
    ) { dutyDao.inserNew(new Duty(0, duty.getUserID(),
                                     duty.getBreakID(),
                                     duty.getPlaceID(),
                                     duty.getDate())); }

    @RequestMapping(value = "/duties/{dutyId}", method = RequestMethod.PUT)
    public void updateDuty(
            @RequestBody Duty duty,
            @PathVariable Integer dutyId
    ) { Duty d = dutyDao.findById(dutyId);
        d.setUserID(duty.getUserID());
        d.setBreakID(duty.getBreakID());
        d.setPlaceID(duty.getPlaceID());
        d.setDate(duty.getDate());
        dutyDao.updateDuty(d); }

    @RequestMapping(value = "/duties/{dutyId}", method = RequestMethod.DELETE)
    public void deleteDuty(@PathVariable Integer dutyId) {
        dutyDao.deleteDuty(dutyId);
    }
}
