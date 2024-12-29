//Create a Book class with title, author, and year. Add several books to a Set<Book>,
// including some with the same author and title.
// Implement equals and hashCode to ensure each book is unique.
package ex12;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();

        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));

    }
}
