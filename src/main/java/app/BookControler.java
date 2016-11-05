package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOImpl;
import app.service.ConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookControler {
    BookDAO bookDAO;

    public BookControler() {
        bookDAO = new BookDAOImpl(ConnectionFactory.getConnection());
    }

    @RequestMapping("/booksold")
    public List<BookOld> listAllBooks(
            @RequestParam(value="adres", defaultValue="") String adres,
            @RequestParam(value="sztuk", defaultValue="1") Integer sztuk
            ) {
        BookOld g = new BookOld("W. Gombrowicz", "Ferdydurke", 101 * sztuk, adres);

        List<BookOld> res = new ArrayList<>();
        res.add(g);
        res.add(g);
        res.add(g);
        return res;
    }

    @RequestMapping("/books/byauthor")
    public List<Book> listBooksByAuthor(
            @RequestParam(value = "author", defaultValue = "") String author) {
        return bookDAO.findByAuthor(author);
    }

    @RequestMapping("/books/all")
    public List<Book> listAllBooks() {
        return bookDAO.findAll();
    }

    @RequestMapping("/books/byid")
    public Book listAllBooks(
            @RequestParam(value = "id", defaultValue = "") String bookid
    ) {
        return bookDAO.getById(Integer.valueOf(bookid));
    }



}
