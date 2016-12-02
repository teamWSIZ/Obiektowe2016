package app.service;

import app.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Dudix on 2016-12-01.
 */
public class UserDAOJdbc implements UserDAO {
    JdbcTemplate template;

    public UserDAOJdbc() {
        this.template = JdbcTemplateFactory.getTemplate();
    }

    @Override
    public void insertNew(User u) {
        template.update(
                "INSERT INTO users (name) VALUES (?)",
                u.getName()
        );
    }

    @Override
    public void delete(Integer userid) {
        template.update(
                "DELETE FROM users WHERE userid=(?)",
                userid
        );
    }

    @Override
    public void update(User u) {
        template.update(
                "UPDATE users SET name=(?) WHERE userid=(?)",
                u.getName(),
                u.getUserid()
        );
    }

    @Override
    public List<User> findAll() {
        return template.query(
            "SELECT * FROM users ORDER BY name ASC",
            new UserMapper()
        );
    }

    @Override
    public User getById(Integer userid) {
        return template.queryForObject(
            "SELECT * FROM users WHERE userid=(?) ORDER BY name ASC",
            new Object[]{userid},
            new UserMapper()
        );
    }

    @Override
    public List<User> findByName(String name) {
        return template.query(
            "SELECT * FROM users WHERE name=(?) ORDER BY name ASC",
            new Object[]{name},
            new UserMapper()
        );
    }
}
