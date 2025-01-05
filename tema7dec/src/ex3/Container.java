package ex3;

import java.util.ArrayList;
import java.util.List;

public class Container <T extends Number>{
    private final List<T> elements;

    public Container(List<T> elements) {
        this.elements = elements;
    }

    public Container() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T element){
        elements.add(element);
    }

    public double sum(){
        double total = 0;
        for(T element: elements){
            total += element.doubleValue();
        }

        return total;
    }
}
