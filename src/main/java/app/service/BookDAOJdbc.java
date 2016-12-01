package app.service;

import app.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Implementacja {@link BookDAO} wykorzystująca {@link JdbcTemplate}.
 */
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
                b.getAuthor(),b.getTitle());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return template.query("select * from book where author=(?)",
                new Object[]{author},
                new BookMapper());
    }

    @Override
    public void delete(Integer bookid) {
        template.update("DELETE FROM book where bookid=(?)", bookid);
    }

    @Override
    public Book getById(Integer bookid) {
        return template.queryForObject(
                "select * from book where bookid=(?)",
                new Object[]{bookid}, new BookMapper());
    }

    @Override
    public void update(Book b) {
        template.update("UPDATE book set title=(?), author=(?) WHERE bookid=(?)",
                b.getTitle(),
                b.getAuthor(),
                b.getBookid());
    }
}
