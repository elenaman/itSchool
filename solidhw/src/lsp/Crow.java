package lsp;

public class Crow extends FlyingBird{

    protected Crow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }

    @Override
    public void eat() {
        System.out.println("Crow is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Crow is sleeping");
    }
}
