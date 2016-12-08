package app.gui;

import app.dialog.EditDialog;
import app.model.Book;
import app.service.BookDAOJdbc;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by charl0tte on 08.12.2016.
 */
public class BookDatabaseGUI {
    private JPanel aaa;
    private JPanel left;
    private JPanel right;
    private JButton deleteBtn;
    private JButton findByTitleBtn;
    private JButton findByAuthBtn;
    private JButton findByIdBtn;
    private JButton findAllBtn;
    private JButton insertBtn;
    private JButton deleteBookButton;
    private JTextArea textArea1;
    private JButton closeBtn;
    private JButton editBtn;
    private JTextField authorField;
    private JTextField titleField;
    private JTextField idField;
    private BookDAOJdbc bookDao;

    public String nullRecord = "No such record. Try again!";

    public void clear() {
        idField.setText(null);
        authorField.setText(null);
        titleField.setText(null);
    }


    public BookDatabaseGUI() {
        bookDao = new BookDAOJdbc();
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText(null);
                if (idField.getText().isEmpty()) {
                    textArea1.setText("Please fill out all the required fields!");
                    return;
                }
                int x = JOptionPane.showConfirmDialog(null, "Do you want to add this book to the database?", "Inserting a new book", JOptionPane.YES_NO_CANCEL_OPTION);
                if (x == 0) {
                    bookDao.insertNew(new Book(Integer.parseInt(idField.getText()), authorField.getText(), titleField.getText()));
                    textArea1.setText("A new book has been inserted successfully! :)");
                    clear();
                }
            }
        });
        findAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText(null);
                List<Book> allBooks = bookDao.findAll();
                if (allBooks.isEmpty()) {
                    textArea1.setText("Sorry, there are no books in the database! :(");
                }
                for (Book n : allBooks) {
                    textArea1.append(n.toString() + "\n");
                }
                clear();
            }
        });
        findByIdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea1.setText(null);
                    if (idField.getText().isEmpty()) {
                        textArea1.setText(nullRecord);
                    } else {
                        Book idBook = bookDao.findById(Integer.parseInt(idField.getText()));
                        textArea1.append(idBook.toString());
                        clear();
                    }
                } catch (EmptyResultDataAccessException e) {
                    textArea1.setText(nullRecord);
                }
            }
        });
        findByAuthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText(null);
                if (authorField.getText().isEmpty()) {
                    textArea1.setText(nullRecord);
                    return;
                }
                List<Book> authorBook = bookDao.findByAuthor(authorField.getText());
               if (authorBook.isEmpty()) {
                   textArea1.setText(nullRecord);
                   return;
               }
               for (Book a : authorBook) {
                   textArea1.append(a.toString() + "\n");
               }
               clear();
            }
        });
        findByTitleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText(null);
                List<Book> titleBooks = bookDao.findByTitle(titleField.getText());
                if (titleBooks.isEmpty()) {
                    textArea1.setText(nullRecord);
                    return;
                }
                for (Book e : titleBooks) {
                    textArea1.append(e.toString() + "\n");
                }
                clear();
            }
        });
        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (idField.getText().isEmpty()) {
                        textArea1.setText(nullRecord);
                    } else {
                        textArea1.setText(null);
                        int a = JOptionPane.showConfirmDialog(null, "Do you really want to delete this book from the database?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (a == 0) {
                            bookDao.deleteBook(Integer.parseInt(idField.getText()));
                            textArea1.setText("Book has been deleted successfully! :)");
                            clear();
                        }
                    }
                } catch (EmptyResultDataAccessException e) {
                    textArea1.setText(nullRecord);
                }
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete all the records from the table?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                if (x == 0) {
                    textArea1.setText(null);
                    bookDao.deleteTable();
                    textArea1.setText("Table is empty now! :)");
                    clear();
                }
            }
        });
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText(null);
                if (idField.getText().isEmpty()) {
                    textArea1.setText(nullRecord);
                } else {
                    Book book = bookDao.findById(Integer.parseInt(idField.getText()));
                    EditDialog dialog = new EditDialog(bookDao, book);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                    textArea1.setText("The book was edited sucessfully! :)");
                    clear();
                }
            }
        });
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BookDatabaseGUI");
        frame.setContentPane(new BookDatabaseGUI().aaa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 371);
        frame.setLocationRelativeTo(null);
    }
}
