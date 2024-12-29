package noClass;

import java.util.ArrayList;
import java.util.List;

//Create a List<String> with book titles.
// Write methods to add a book title, remove a title, and check if a specific title exists.
public class ex4 {
    public static void main(String[] args) {
        List<String> bookTitles = new ArrayList<>();
        bookTitles.add("To Kill a Mockingbird");
        bookTitles.add("1984");
        bookTitles.add("The Great Gatsby");
        bookTitles.add("Moby Dick");
        bookTitles.add("Pride and Prejudice");
        bookTitles.add("The Catcher in the Rye");

        //add a book title
        addTitle("Harry Potter", bookTitles);

        //remove a book title
        removeTitle("1984", bookTitles);

        //check if exists
        doesExist("Moby Dick", bookTitles);
    }

    private static void doesExist(String bookTitle, List<String> bookTitles) {
        if(bookTitles.contains(bookTitle)){
            System.out.println("The book exists.");
        } else {
            System.out.println("The book does not exist in the list.");
        }
    }

    private static void removeTitle(String bookTitle, List<String> bookTitles) {
        if(bookTitles.contains(bookTitle)){
            bookTitles.remove(bookTitle);
        } else {
            System.out.println("The book does not exist in the list and it cannot be removed.");
        }
    }

    private static void addTitle(String bookTitle, List<String> bookTitles) {
        if(!bookTitles.contains(bookTitle)){
            bookTitles.add(bookTitle);
        } else {
            System.out.println("The book already exists in the list.");
        }
    }
}
