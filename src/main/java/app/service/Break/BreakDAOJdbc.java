package app.service.Break;


import app.model.Break;
import app.service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BreakDAOJdbc implements BreakDAO {
    JdbcTemplate template;

    public BreakDAOJdbc() { this.template = JdbcTemplateFactory.getTemplate(); }

    @Override
    public List<Break> findAll() {
        return template.query("select * from breaks", new BreakMapper());
    }

    @Override
    public Break getById(Integer breakId) {
        return template.queryForObject(
                "select * from breaks where breakid=(?)",
                new Object[]{breakId}, new BreakMapper());
    }

    @Override
    public void inserNew(Break b) {
        template.update("insert into breaks (breakname)",
                b.getBreakName());
    }

    @Override
    public void updateBreak(Break b) {
        template.update("update breaks set breakname=(?) where breakid=(?)",
                b.getBreakName(), b.getBreakID());
    }

    @Override
    public void deleteBreak(Integer breakId) {
        template.update("delete from breaks where breakid=(?)", breakId);
    }
}
