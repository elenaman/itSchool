package lsp;

public abstract class Bird {
    private final String name;
    protected Bird(String name) {
        this.name = name;
    }
    public abstract void eat();
    public abstract void sleep();

}
