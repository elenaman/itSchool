package ex4;

import java.util.ArrayList;
import java.util.List;

public class ShapeContainer<T extends Shape> {
    private final List<T> shapes;
    public ShapeContainer() {
        this.shapes = new ArrayList<>();
    }

    public ShapeContainer(List<T> shapes) {
        this.shapes = shapes;
    }

    public void addShape(T shape){
        shapes.add(shape);
    }

    public void addShapesFromList(List<? extends T> shapeList) {
        shapes.addAll(shapeList);
    }

    public List<T> filterShapesByArea(double minArea) {
        List<T> filteredShapes = new ArrayList<>();
        for (T shape : shapes) {
            if (shape.area() >= minArea) {
                filteredShapes.add(shape);
            }
        }
        return filteredShapes;
    }

    public void displayShapes() {
        for (T shape : shapes) {
            System.out.println(shape);
        }
    }



}
