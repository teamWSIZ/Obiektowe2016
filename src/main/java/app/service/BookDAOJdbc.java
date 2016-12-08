package app.service;

import app.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDAOJdbc implements BookDAO {
    JdbcTemplate template;

    public BookDAOJdbc() {
        this.template = JdbcTemplateFactory.getTemplate();
    }

    @Override
    public List<Book> findAll() {
        return template.query("select * from book", new BookMapper());
    }

    @Override
    public void insertNew(Book b) {
        template.update("insert into book (author,title) values (?,?) ",
                b.getAuthor(), b.getTitle());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return template.query("select * from book where author=(?)",
                new Object[]{author},
                new BookMapper());
    }

    @Override
    public List<Book> findByTitle(String title) {
        return template.query("select * from book where title=(?)",
                new Object[]{title},
                new BookMapper());
    }

    @Override
    public Book findById(Integer id) {
        return template.queryForObject("select * from book where id=(?)",
                new Object[]{id},
                new BookMapper());
    }

    @Override
    public void editBook(Book book) {
        template.update("UPDATE book SET author=(?), title=(?) WHERE id=(?)",
                book.getAuthor(), book.getTitle(), book.getBookid());
    }

    @Override
    public void deleteBook(Integer bookid) {
        template.update("delete from book where id=(?)", bookid);
    }

    @Override
    public void deleteTable() {
        template.update("delete from book");
    }

}
