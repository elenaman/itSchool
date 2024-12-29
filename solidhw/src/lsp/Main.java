package lsp;
/**
 * Refactor the code to ensure it adheres to LSP.
 */
public class Main {
    public static void main(String[] args) {
        Bird penguin = new Penguin("Pingu");
        penguin.eat();
        penguin.sleep();

        Bird crow = new Crow("Crowi");
        crow.eat();
        crow.sleep();
        ((Crow) crow).fly();
    }

}
