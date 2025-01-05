package ex1;

public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(42);
        System.out.println(integerBox.getItem());
        integerBox.clear();

        Box<String> stringBox = new Box<>("New string box");
        System.out.println(stringBox.getItem());
        stringBox.clear();
    }
}
