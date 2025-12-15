package business;

import entities.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<Book> books = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    // KİTAP EKLE
    public boolean addBook(int id, String title, String author) {
        if (findBookById(id) != null) return false;
        books.add(new Book(id, title, author));
        return true;
    }

    // KİTAP SİL
    public boolean removeBook(int id) {
        return books.removeIf(b -> b.getId() == id);
    }

    // KİTAP LİSTELE
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Kitap yok.");
            return;
        }
        books.forEach(System.out::println);
    }

    // KİTAP ARA
    public Book searchBook(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);
    }

    // ÖDÜNÇ AL
    public boolean borrowBook(int bookId, Member member) {
        Book book = findBookById(bookId);
        if (book == null || !book.isAvailable()) return false;
        loans.add(new Loan(book, member));
        return true;
    }

    // İADE
    public Double returnBook(int bookId) {
        for (Loan l : loans) {
            if (l.getBook().getId() == bookId) {
                l.returnBook();
                loans.remove(l);
                return l.calculateFee();
            }
        }
        return null;
    }

    private Book findBookById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst().orElse(null);
    }
}