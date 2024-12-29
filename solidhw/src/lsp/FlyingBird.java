package lsp;

public abstract class FlyingBird extends Bird{
    protected FlyingBird(String name) {
        super(name);
    }

    public abstract void fly();
}
