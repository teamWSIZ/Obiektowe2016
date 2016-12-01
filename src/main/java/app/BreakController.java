package app;

import app.model.Break;
import app.service.Break.BreakDAO;
import app.service.Break.BreakDAOJdbc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BreakController {
    BreakDAO breakDAO;

    public BreakController() { breakDAO = new BreakDAOJdbc(); }

    @RequestMapping(value = "/breaks", method = RequestMethod.GET)
    public List<Break> allBreaks() { return breakDAO.findAll(); }

    @RequestMapping(value = "/breaks/{breakId}", method = RequestMethod.GET)
    public Break getBreakInfo(@PathVariable Integer breakId) {
        Break b = breakDAO.getById(breakId);
        return b;
    }

    @RequestMapping(value = "/breaks", method = RequestMethod.POST)
    public void createBreak(
            @RequestParam(value = "breakName", defaultValue = "") String breakName
    ) { breakDAO.inserNew(new Break(0,breakName)); }

    @RequestMapping(value = "/breaks/{breakId}", method = RequestMethod.PUT)
    public void updateBreak(
            @RequestParam(value = "breakName", defaultValue = "") String breakName,
            @PathVariable Integer breakId
    ) { breakDAO.updateBreak(breakDAO.getById(breakId)); } //// TODO: 2016-12-01

    @RequestMapping(value = "/breaks/{breakId}", method = RequestMethod.DELETE)
    public void deleteBreak(@PathVariable Integer breakId) {
        breakDAO.deleteBreak(breakId);
    }
}
