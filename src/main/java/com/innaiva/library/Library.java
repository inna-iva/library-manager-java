package com.innaiva.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        //return null; //if not found-not correct: will output RunTimeException
        throw new IllegalArgumentException("Book with id " + id + " not found");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        }
        for (Book b : books) {
            b.printInfo();
        }
    }

    public boolean borrowBook(int id) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Book already borrowed.");
            return false;
        }

        book.setAvailable(false);
        System.out.println("You borrowed: " + book.getTitle());

        return true;
    }

    public boolean returnBook(int id) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (book.isAvailable()) {
            System.out.println("Book is already returned.");
            return false;
        }

        book.setAvailable(true);
        System.out.println("You returned: " + book.getTitle());

        return true;
    }

    public List<Book> getBooks() {
        return books;
    }
}
