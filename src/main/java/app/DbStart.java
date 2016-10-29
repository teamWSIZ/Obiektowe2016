package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created on 15.10.16, at 07:29
 */
public class DbStart {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/nowabaza", "sa", "");
        BookDAO dao = new BookDAOImpl(conn);


        dao.insertNew(new Book(0,"Rowling", "Harry Potter and the Cursed Child"));


        List<Book> books = dao.findAll();
        for(Book b : books) {
            System.out.println(b);
        }

        // tutaj kod działający na bazie
        conn.close();

    }
}
