package app.service.user;

import app.model.User;
import app.service.*;
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
                "INSERT INTO user (username) VALUES (?)",
                u.getUsername()
        );
    }

    @Override
    public void delete(Integer userid) {
        template.update(
                "DELETE FROM user WHERE userid=(?)",
                userid
        );
    }

    @Override
    public void update(User u) {
        template.update(
                "UPDATE user SET username=(?) WHERE userid=(?)",
                u.getUsername(),
                u.getUserid()
        );
    }

    @Override
    public List<User> findAll() {
        return template.query(
            "SELECT * FROM user ORDER BY username ASC",
            new UserMapper()
        );
    }

    @Override
    public User getById(Integer userid) {
        return template.queryForObject(
            "SELECT * FROM user WHERE userid=(?) ORDER BY username ASC",
            new Object[]{userid},
            new UserMapper()
        );
    }

    @Override
    public List<User> findByName(String name) {
        return template.query(
            "SELECT * FROM user WHERE username=(?) ORDER BY username ASC",
            new Object[]{name},
            new UserMapper()
        );
    }
}
