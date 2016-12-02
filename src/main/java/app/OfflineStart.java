package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOJdbc;

/**
 * Wolnostojąca aplikacja (po prostu uruchamilana) do uruchamiania i
 * testowania obietków typu DAO manipulujących danymi na bazie.
 *
 * Pisane na podstawie:
 * https://www.tutorialspoint.com/spring/spring_jdbc_example.htm
 */
public class OfflineStart {
    public static void main(String[] args) {
        BookDAO dao = new BookDAOJdbc();
        System.out.println(dao.getById(36));
        Book b = dao.getById(36);
        b.setAuthor("Rowling, J.");
        dao.update(b);
        System.out.println(dao.getById(36));
//        dao.insertNew(new Book(0,"Abra kadabra", "Don Pedro"));
//        dao.delete(67);
//        System.out.println(dao.findAll());
//        System.out.println("-----------");
//        System.out.println(dao.findByAuthor("Rowling"));
    }
}