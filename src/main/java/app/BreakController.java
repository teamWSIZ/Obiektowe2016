package app;

import app.model.Break;
import app.service.Break.BreakDAO;
import app.service.Break.BreakDAOJdbc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BreakController {
    BreakDAO breakDAO;

    public BreakController() { breakDAO = new BreakDAOJdbc(); }

    @RequestMapping(value = "/breaks", method = RequestMethod.GET)
    public List<Break> allBreaks() {
        System.out.println(breakDAO.findAll());
        return breakDAO.findAll(); }

    @RequestMapping(value = "/breaks/{breakId}", method = RequestMethod.GET)
    public Break getBreakInfo(@PathVariable Integer breakId) {
        Break b = breakDAO.getById(breakId);
        return b;
    }

    @RequestMapping(value = "/breaks", method = RequestMethod.POST)
    public void createBreak(
            @RequestBody Break b
    ) { breakDAO.inserNew(new Break(0, b.getName())); }

    @RequestMapping(value = "/breaks/{breakId}", method = RequestMethod.PUT)
    public void updateBreak(
            @RequestBody Break br,
            @PathVariable Integer breakId
    ) { Break b = breakDAO.getById(breakId);
        b.setName(br.getName());
        breakDAO.updateBreak(b); }

    @RequestMapping(value = "/breaks/{breakId}", method = RequestMethod.DELETE)
    public void deleteBreak(@PathVariable Integer breakId) {
        breakDAO.deleteBreak(breakId);
    }
}
