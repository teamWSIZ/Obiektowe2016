package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ta klasa (entity) odpowiada rzędom tabeli "BOOK" na bazie danych.
 *
 * Jeśli będziemy potrzebowali dodać tam dodatkowej kolumny (np.
 * ISBN) to trzeba:
 * - dodać na bazie
 * - dodać tutaj w klasie
 * - dodać w BookMapper
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    Integer bookid;
    String title;
    String author;

}
