package ex12;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book book){
            return book.author.equals(this.author)
                    && book.title.equals(this.title);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return author.length()+title.length();
    }
}
