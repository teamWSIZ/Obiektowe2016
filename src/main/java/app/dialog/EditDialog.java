package app.dialog;

import app.model.Book;
import app.service.BookDAOJdbc;

import javax.swing.*;
import java.awt.event.*;

public class EditDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField newAuthorField;
    private JTextField newTitleField;
    private Book editedBook;
    private BookDAOJdbc bookDao;

    public EditDialog(BookDAOJdbc dao, Book editBook) {
        this.editedBook = editBook;
        this.bookDao = dao;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (!newAuthorField.getText().isEmpty()) {
            editedBook.setAuthor(newAuthorField.getText());
        }
        if (!newTitleField.getText().isEmpty()) {
            editedBook.setTitle(newTitleField.getText());
        }
        bookDao.editBook(editedBook);
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
