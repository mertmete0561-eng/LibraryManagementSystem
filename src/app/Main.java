package app;

import business.LibraryManager;
import entities.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);

        Member admin = new Member(1, "Admin", true);
        Member user = new StudentMember(2, "Ali");

        int choice;
        do {
            System.out.println("\n1- Kitap Listele");
            System.out.println("2- Kitap Ara");
            System.out.println("3- Kitap Ödünç Al");
            System.out.println("4- Kitap İade Et");
            System.out.println("5- Kitap Ekle (Admin)");
            System.out.println("6- Kitap Sil (Admin)");
            System.out.println("0- Çıkış");
            System.out.print("Seçim: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.listBooks();

                case 2 -> {
                    System.out.print("Kitap adı: ");
                    String title = sc.nextLine();
                    Book b = manager.searchBook(title);
                    System.out.println(b == null ? "Bulunamadı" : b);
                }

                case 3 -> {
                    System.out.print("Kitap ID: ");
                    int id = sc.nextInt();
                    System.out.println(manager.borrowBook(id, user)
                            ? "Ödünç alındı"
                            : "İşlem başarısız");
                }

                case 4 -> {
                    System.out.print("Kitap ID: ");
                    int id = sc.nextInt();
                    Double fee = manager.returnBook(id);
                    if (fee == null) System.out.println("Kayıt yok");
                    else System.out.println("İade edildi. Ceza: " + fee + " TL");
                }

                case 5 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ad: ");
                    String t = sc.nextLine();
                    System.out.print("Yazar: ");
                    String a = sc.nextLine();
                    System.out.println(manager.addBook(id, t, a)
                            ? "Kitap eklendi"
                            : "ID zaten var");
                }

                case 6 -> {
                    System.out.print("Kitap ID: ");
                    int id = sc.nextInt();
                    System.out.println(manager.removeBook(id)
                            ? "Silindi"
                            : "Bulunamadı");
                }
            }

        } while (choice != 0);
    }
}