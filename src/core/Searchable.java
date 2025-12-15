package core;

import entities.Book;

public interface Searchable {
    Book searchByTitle(String title);
}