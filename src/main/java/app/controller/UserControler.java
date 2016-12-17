package app.controller;

import app.model.User;
import app.service.user.UserDAO;
import app.service.user.UserDAOJdbc;
import exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Created by Dudix on 2016-12-01.
 */
@CrossOrigin(origins = "*")
@RestController
public class UserControler {
    UserDAO userDAO;

    public UserControler() {
        userDAO = new UserDAOJdbc();
    }


    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userDAO.insertNew(new User(0,user.getUsername()));
    }

    @RequestMapping(value = "/users/{userid}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Integer userid, @RequestBody User user) {
        userDAO.update(new User(userid, user.getUsername()));
    }

    @RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer userid) {
        userDAO.delete(userid);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        return userDAO.findAll();
    }

    @RequestMapping(value = "/users/byid", method = RequestMethod.GET)
    public User listAllUsers(
            @RequestParam(value = "id", defaultValue = "") String userid
    ) {
        return userDAO.getById(Integer.valueOf(userid));
    }

    @RequestMapping(value = "/users/byname", method = RequestMethod.GET)
    public List<User> listUsersByName(@RequestBody User user) {
        return userDAO.findByName(user.getUsername());
    }

    @RequestMapping(value = "/users/{userid}", method = RequestMethod.GET)
    public User getUserInfo(@PathVariable Integer userid) {
        User u = userDAO.getById(userid);
        System.out.println(u);
        if (u==null) {
            throw new NotFoundException(); //narazie nie działa
        }
        return u;
    }

}
