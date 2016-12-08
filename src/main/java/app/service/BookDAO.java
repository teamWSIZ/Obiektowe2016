package app.service;


import app.model.Book;

import java.util.List;

public interface BookDAO {

    public List<Book> findAll();

    public void insertNew(Book b);

    public List<Book> findByAuthor(String author);

    public List<Book> findByTitle(String title);

    public Book findById(Integer id);

    public void editBook(Book book);

    public void deleteBook(Integer bookid);

    public void deleteTable();
}
