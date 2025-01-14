package ex2;

import java.util.*;
import java.util.stream.Collectors;

//Use streams to:
//-- Remove duplicates based on the ISBN.
//-- Find the book with the highest price.
//-- Group books by author and count how many books each author has.
public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("12345", "Book A", "Author A", 29.99));
        books.add(new Book("12345", "Book A", "Author A", 35.99));
        books.add(new Book("67890", "Book B", "Author B", 19.99));
        books.add(new Book("54321", "Book C", "Author C", 25.50));
        books.add(new Book("67890", "Book B", "Author B", 22.99));


        List<Book> distinctBooks = books.stream()
                .distinct()
                .toList();
        distinctBooks.forEach(s-> System.out.println(s.title));

        Book mostExpensiveBook = books.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
        System.out.println(mostExpensiveBook.author);


        Map<String, Long> groupedBooks = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));

        groupedBooks.forEach((s, aLong) -> System.out.println(s+ " " + aLong));



    }
}
