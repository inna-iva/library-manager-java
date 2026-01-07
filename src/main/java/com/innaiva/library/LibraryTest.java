package com.innaiva.library;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book(1, "TestJava", "Inna Iva");

        library.addBook(book);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testFindBookNotFound(){
        Library library = new Library();

        assertThrows(IllegalArgumentException.class, () -> {
            library.findBookById(99);
        });
    }

    @Test
    public void testBorrowBook(){
        Library library = new Library();
        Book book = new Book (1, "Java", "Smith");
        User user = new User(1, "Sam");

        library.addBook(book);
        library.addUser(user);

        library.borrowBook(1, 1);
        assertFalse(book.isAvailable());
    }
    @Test
    public void testShouldNotAllowBorrowingBorrowBook() {
        Library library = new Library();
        Book book = new Book(1, "Java", "Smith");
        User user = new User(1, "Sam");

        library.addBook(book);
        library.addUser(user);
        library.borrowBook(1, 1);

        assertThrows(IllegalStateException.class, () -> {
            library.borrowBook(1, 1);
        });
    }

    @Test
    public void testReturnBook(){
        Library library = new Library();
        Book book = new Book(1, "Java", "Smith");
        User user = new User(1, "Sam");

        library.addBook(book);
        library.addUser(user);
        library.borrowBook(1, 1);

        library.returnBook(1);

        assertTrue(book.isAvailable());
    }
}