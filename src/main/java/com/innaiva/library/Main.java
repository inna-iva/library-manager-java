package com.innaiva.library;

public class Main {
    public static void main(String[] args) {
        // Test basic OOP work
        Book book = new Book(1, "River", "Alex Konsky");
        User user = new User(1, "Inna");

        book.printInfo();
        user.printInfo();
    }
}