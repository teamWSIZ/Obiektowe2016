package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOJdbc;
import lombok.extern.slf4j.Slf4j;

/**
 * Pisane na podstawie:
 * https://www.tutorialspoint.com/spring/spring_jdbc_example.htm
 */

@Slf4j
public class OfflineStart {
    public static void main(String[] args) {
        log.debug("Start programu");
        BookDAO dao = new BookDAOJdbc();
        System.out.println(dao.getById(35));
        Book b = dao.getById(35);
        b.setAuthor("Rowling, J.");
        dao.update(b);
        System.out.println(dao.getById(35));
//        dao.insertNew(new Book(0,"Abra kadabra", "Don Pedro"));
//        dao.delete(67);
//        System.out.println(dao.findAll());
//        System.out.println("-----------");
//        System.out.println(dao.findByAuthor("Rowling"));
        log.debug("Koniec programu");
    }
}
