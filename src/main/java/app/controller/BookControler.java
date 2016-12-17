package app.controller;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOJdbc;
import exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookControler {
    BookDAO bookDAO;

    public BookControler() {
        bookDAO = new BookDAOJdbc();
    }

    @RequestMapping(value = "/books/byauthor", method = RequestMethod.GET)
    public List<Book> listBooksByAuthor(
            @RequestParam(value = "author", defaultValue = "") String author) {
        return bookDAO.findByAuthor(author);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> listAllBooks() {
        return bookDAO.findAll();
    }

    @RequestMapping(value = "/books/{bookid}", method = RequestMethod.GET)
    public Book getBookInfo(@PathVariable Integer bookid) {
        Book b = bookDAO.getById(bookid);
        System.out.println(b);
        if (b==null) {
            throw new NotFoundException(); //narazie nie działa
        }
        return b;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void createBook(
            @RequestParam(value = "author", defaultValue = "") String author,
            @RequestParam(value = "title", defaultValue = "") String title
    ) {
        bookDAO.insertNew(new Book(0,title,author));
    }
    @RequestMapping(value = "/books/{bookid}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Integer bookid) {
        bookDAO.delete(bookid);
    }








    @RequestMapping("/books/all")
    public List<Book> listAllBookz() {
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
