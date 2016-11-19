package app;

import app.service.BookDAO;
import app.service.BookDAOJdbc;

/**
 * Created on 19.11.16, at 08:56
 */
public class OfflineStart {
    public static void main(String[] args) {
        BookDAO dao = new BookDAOJdbc();
        System.out.println(dao.findAll());
        System.out.println("-----------");
        System.out.println(dao.findByAuthor("Rowling"));
    }
}
