package app.service;


import app.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book b = new Book();
        b.setBookid(rs.getInt("id"));
        b.setAuthor(rs.getString("author"));
        b.setTitle(rs.getString("title"));
        return b;
    }
}
