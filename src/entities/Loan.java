package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {

    private Book book;
    private Member member;
    private LocalDate dueDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.dueDate = LocalDate.now().plusDays(7);
        book.setAvailable(false);
    }

    public Book getBook() { return book; }

    public void returnBook() {
        book.setAvailable(true);
    }

    public double calculateFee() {
        long days = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        return member.calculateFee((int) Math.max(days, 0));
    }
}