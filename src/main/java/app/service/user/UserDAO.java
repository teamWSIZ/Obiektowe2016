package app.service.user;

import app.model.User;

import java.util.List;

/**
 * Created by Dudix on 2016-12-01.
 */
public interface UserDAO {

    void insertNew(User b);

    void update(User b);

    void delete(Integer userid);

    List<User> findAll();

    User getById(Integer userid);

    List<User> findByName(String name);
}
