package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * Created on 15.10.16, at 07:29
 */
public class SystemStart {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/nowabaza", "sa", "");
        BookDAO bookDAO = new BookDAOImpl(conn);

        // tutaj kod działający na bazie
        conn.close();

    }
}
