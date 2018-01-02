package app.service;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOJdbc;
import exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BookController {
    BookDAO bookDAO;

    public BookController() {
        bookDAO = new BookDAOJdbc();
    }

    // po autorze
    @RequestMapping(value = "/books/byauthor", method = RequestMethod.GET)
    public List<Book> listBooksByAuthor(
            @RequestParam(value = "author", defaultValue = "") String author) {
        return bookDAO.findByAuthor(author);
    }

    // po tytule
    @RequestMapping(value = "/books/bytitle", method = RequestMethod.GET)
    public List<Book> listBooksByTitle(
            @RequestParam(value = "title", defaultValue = "") String title) {
        return bookDAO.findByTitle(title);
    }

    // po id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book getBookInfo(@PathVariable Integer id) {
        Book b = bookDAO.findById(id);
        System.out.println(b);
        if (b == null) {
            throw new NotFoundException(); //narazie nie działa
        }
        return b;
    }

    //edytowanie książki o danym id
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public void editBook(@PathVariable Integer id, @RequestBody Book book) {
        bookDAO.editBook(new Book(id, book.getAuthor(), book.getTitle()));
    }

    // wszystkie książki
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> listAllBooks() {
        return bookDAO.findAll();
    }

    // usuwanie książki
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Integer id) {
        bookDAO.deleteBook(id);
    }

    // dodawanie nowej książki
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public void createBook(
            @RequestParam(value = "author", defaultValue = "") String newAuthor,
            @RequestParam(value = "title", defaultValue = "") String newTitle
    ) {
        bookDAO.insertNew(new Book(null, newAuthor, newTitle));
    }

}
