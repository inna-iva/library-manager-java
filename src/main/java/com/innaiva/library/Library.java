package com.innaiva.library;

import java.util.*;

public class Library {
    private Map<Integer, Integer> borrowedBooks = new HashMap<>();
    private final List<Book> books = new ArrayList<>();
    private final Set<User> users = new HashSet<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void addUser(User user) {
        users.add(user);
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

    public void returnBook(int bookId) {

        if(!borrowedBooks.containsKey(bookId)) {
            throw new IllegalStateException("This book was not borrowed");
        }

        Book book = findBookById(bookId);
        book.setAvailable(true);
        borrowedBooks.remove(bookId);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void borrowBook (int bookId, int userId){
        Book book = findBookById(bookId);

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already borrowed");
        }

        book.setAvailable(false);
        borrowedBooks.put(bookId, userId);
    }

}
