package com.mavenproject1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Book {
    private static int lastId = 0;
    private int id;
    private int idCounter;
    private String title;
    private String author;
    private int genre;
    private double price;
    private String isbn;
   

    public Book( int id, int genre, String title, String author, String bn, double price, String bn1) {
    
    }

   
    public String[] genreChoices = {"NetWork", "AI", "Programming"};
     public Book(int id) {
        this.id = ++lastId;
       
    }

    public Book() {
    }
     


    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }
    public void getPrice(double price){
        this.price = price;
    }
 

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book( int id, int idCounter, String title, String author, int genre, double price, String isbn) {
       this.id =0;
        this.idCounter = idCounter;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.isbn = isbn;
    }

    public int getId() {
      
        return 0;
      
    }

    public void setPrice(double price) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
}
