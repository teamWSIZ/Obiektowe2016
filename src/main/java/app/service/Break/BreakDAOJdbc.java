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
        return template.query("select * from break", new BreakMapper());
    }

    @Override
    public Break getById(Integer breakId) {
        return template.queryForObject(
                "select * from break where breakid=(?)",
                new Object[]{breakId}, new BreakMapper());
    }

    @Override
    public void inserNew(Break b) {
        template.update("insert into break (breakname) values (?)",
                b.getBreakname());
    }

    @Override
    public void updateBreak(Break b) {
        template.update("update break set breakname=(?) where breakid=(?)",
                b.getBreakname(), b.getBreakid());
    }

    @Override
    public void deleteBreak(Integer breakId) {
        template.update("delete from break where breakid=(?)", breakId);
    }
}
