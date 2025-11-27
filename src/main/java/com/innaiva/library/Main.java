package com.innaiva.library;

public class Main {
    public static void main(String[] args) {
        // Test basic OOP work
        Book book = new Book(1, "River", "Alex Konsky");
        User user = new User(1, "Inna");

        book.printInfo();
        user.printInfo();

        Library library = new Library();

        library.addBook(new Book(2, "Java Theory", "Smith"));
        library.addBook(new Book(3, "Python", "Kohen S."));
        library.addBook(new Book(4, "Algorithms", "Kevin Bowie"));

        System.out.println("\nAll books:");
        library.listBooks();

        System.out.println("\nBorrowing book 2:");
        library.borrowBook(2);

        System.out.println("\nTrying to borrow book 2 again:");
        library.borrowBook(2);

        System.out.println("\nReturning book 2:");
        library.returnBook(2);

        System.out.println("\nFinal state:");
        library.listBooks();
    }
}