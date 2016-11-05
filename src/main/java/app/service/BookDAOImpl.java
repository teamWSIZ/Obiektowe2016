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
        try {
            PreparedStatement st = conn.prepareStatement("select * from book");
            return getBooks(st);
        } catch (SQLException e) {
            System.out.println("Błąd pobierania danych " + e);
        }
        return null;
    }


    @Override
    public List<Book> findByAuthor(String author) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from book where author=(?)");
            st.setString(1, author);
            return getBooks(st);
        } catch (SQLException e) {
            System.out.println("Błąd pobierania danych " + e);
        }
        return null;
    }



    @Override
    public void insertNew(Book b) {
        try {
            PreparedStatement st1 = conn.prepareStatement("insert into book (author,title) values (?,?)");
            st1.setString(1, b.getAuthor());
            st1.setString(2, b.getTitle());
            st1.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd pobierania danych " + e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement st = conn.prepareStatement("delete from book where bookid=(?)");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getById(Integer bookid) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * from book where bookid=(?)");
            List<Book> books = getBooks(st);
            if (books.size()!=1) return null;
            return books.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Book b) {
        Integer id = b.getBookid();
        if (id==null || id==0) return;
        try {
            PreparedStatement st = conn.prepareStatement(
                    "update book set title=(?), author=(?) where bookid=(?)");
            st.setString(1, b.getTitle());
            st.setString(2, b.getAuthor());
            st.setInt(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Mamy "preparedStatement", czyli przygotowane zapytanie, chcemy go wykonać na bazie
    // i odczytać listę książek która zawsze będzie w odpowiedzi.
    // dostajemy ResutSet, który zawiera listę obiektów typu Book, chcemy z niego wyrwać
    // List<Book>
    private List<Book> getBooks(PreparedStatement statement) {
        List<Book> res = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer bookid = rs.getInt("bookid");
                String author = rs.getString("author");
                String title = rs.getString("title");
                res.add(new Book(bookid, title, author));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
