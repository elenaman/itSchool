package ex4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShapeContainer<Shape> container = new ShapeContainer<>();

        container.addShape(new Circle(5));
        container.addShape(new Rectangle(4, 6));

        List<Shape> additionalShapes = new ArrayList<>();
        additionalShapes.add(new Circle(3));
        additionalShapes.add(new Rectangle(2, 3));
        container.addShapesFromList(additionalShapes);

        System.out.println("All shapes in the container:");
        container.displayShapes();

        List<Shape> filteredShapes = container.filterShapesByArea(20.0);
        for (Shape shape : filteredShapes) {
            System.out.println(shape.area());
        }
    }
}
