package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOImpl;
import app.service.BookMapper;
import app.service.JdbcTemplateFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
        //Łączenie na bazę na extra niestandardowym porcie 1111.
        //Jeśli była uruchamiana normalnie, to można pominąć 1111
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/nowabaza", "sa", "");


        JdbcTemplate template = JdbcTemplateFactory.getTemplate();
//        template.update("insert into book (author,title) values (?,?) ", "sometext","title");
//        template.update("delete from book where author=(?)", "sometext");
        List<Book> bookz = template.query("select * from book", new BookMapper());
        System.out.println("-------");
        System.out.println(bookz);
        System.out.println("-------");
        //https://www.tutorialspoint.com/spring/spring_jdbc_example.htm


        BookDAO bookDAO = new BookDAOImpl(conn);


//        bookDAO.insertNew(new Book(0, "Ferdydurke", "Gombrowicz"));
//        bookDAO.insertNew(new Book(0, "Harry Potter and the Cursed Child", "Rowling"));
//        bookDAO.insertNew(new Book(0,"Harry Potter and the Sorcerer's Stone", "Rowling"));


        Book doUpdate = new Book(1, "Ferdydurke", "W. Gombrowicz");
//        bookDAO.delete(37);
        bookDAO.update(doUpdate);

        List<Book> books = bookDAO.findAll();
        for(Book b : books) {
            System.out.println(b);
        }

        // tutaj kod działający na bazie
        conn.close();

    }
}
