package app.service;



import app.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    Connection conn;

    public BookDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Book> findAll() {
        List<Book> res = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from book");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer bookid = rs.getInt("bookid");
                String author = rs.getString("author");
                String title = rs.getString("title");
                res.add(new Book(bookid, title, author));
            }
        } catch (SQLException e) {
            System.out.println("Błąd pobierania danych");
        }
        return res;
    }

    @Override
    public void insertNew(Book b) {
        try {
            PreparedStatement st1 = conn.prepareStatement("insert into book (author,title) values (?,?)");
            st1.setString(1, b.getAuthor());
            st1.setString(2, b.getTitle());
            st1.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd pobierania danych");
        }
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return null;
    }
}
