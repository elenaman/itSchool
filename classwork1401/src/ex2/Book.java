package ex2;

import ex1.Student;

import java.util.Objects;

//Create a Book class with:
//
//- String isbn
//- String title
//- String author
//- double price
//
//- Override equals and hashCode so books are distinct based on isbn.
public class Book {
    String isbn;
    String title;
    String author;
    Double price;

    public Book(String isbn, String title, String author, Double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book book){
            return book.isbn.equals(this.isbn);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
