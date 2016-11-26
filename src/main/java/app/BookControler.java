package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOJdbc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookControler {
    BookDAO bookDAO;

    public BookControler() {
        bookDAO = new BookDAOJdbc();
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

    @RequestMapping("/books/add")
    public void listAllBooks(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "author") String author
    ) {
        Book b = new Book(0, title, author);
        bookDAO.insertNew(b);
    }


}
