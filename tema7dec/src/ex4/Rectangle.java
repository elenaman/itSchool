package ex4;

public class Rectangle extends Shape{
    private final int width;
    private final int height;


    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public double area() {
        return width*height;
    }
}
