package app;

import app.model.Duty;
import app.service.duty.DutyDAOJdbc;
import app.service.duty.DutyDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

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
            @RequestParam(value = "userId", defaultValue = "") Integer userId,
            @RequestParam(value = "breakId", defaultValue = "") Integer breakId,
            @RequestParam(value = "placeId", defaultValue = "") Integer placeId,
            @RequestParam(value = "date", defaultValue = "") Date date
    ) { dutyDao.inserNew(new Duty(0, userId, breakId, placeId, date)); }

    @RequestMapping(value = "/duties/{dutyId}", method = RequestMethod.PUT)
    public void updateDuty(
            @RequestParam(value = "userId", defaultValue = "") Integer userId,
            @RequestParam(value = "breakId", defaultValue = "") Integer breakId,
            @RequestParam(value = "placeId", defaultValue = "") Integer placeId,
            @RequestParam(value = "date", defaultValue = "") Date date,
            @PathVariable Integer dutyId
    ) { Duty d = dutyDao.findById(dutyId);
        d.setUserID(userId);
        d.setBreakID(breakId);
        d.setPlaceID(placeId);
        d.setDate(date);
        dutyDao.updateDuty(d); }

    @RequestMapping(value = "/duties/{dutyId}", method = RequestMethod.DELETE)
    public void deleteDuty(@PathVariable Integer dutyId) {
        dutyDao.deleteDuty(dutyId);
    }
}
