package app.service;


import app.model.Book;

import java.util.List;

public interface BookDAO {

    public List<Book> findAll();

    public void insertNew(Book b);

    public List<Book> findByAuthor(String author);
}
