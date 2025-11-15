package com.innaiva.library;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private boolean available = true;

    public Book(int id, String title,String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    public void printInfo(){
        System.out.println("Book [" + id + "] " + title +
                " by " + author + " | Available: " +
                available);
    }
}
