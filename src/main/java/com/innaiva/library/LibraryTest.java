package com.innaiva.library;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;


public class LibraryTest {

    @Test
    void testAddBook() {
        Library library = new Library();
        Book book = new Book(1, "TestJava", "Inna Iva");

        library.addBook(book);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    void testFindBookNotFound(){
        Library library = new Library();

        assertThrows(IllegalArgumentException.class, () -> {
            library.findBookById(99);
        });
    }
}