package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    Integer bookid;
    String author;
    String title;

    @Override
    public String toString() {
        return bookid + ", " + author + ", " + title;
    }
}
