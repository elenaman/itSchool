package lsp;

public class Penguin extends Bird {
    protected Penguin(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }
    @Override
    public void sleep() {
        System.out.println("Penguin is sleeping");
    }
}
