package app.service;


import app.model.Book;

import java.util.List;


// CRUD repository
// (C)reate, R(ead), U(pdate) D(elete)

public interface BookDAO {

    public List<Book> findAll();

    public void insertNew(Book b);

    public List<Book> findByAuthor(String author);

    public void delete(Integer bookid);

    public Book getById(Integer bookid);

    public void update(Book b); //zakładamy b.bookid !=0; czyli, że książka jest już w bazie
}
