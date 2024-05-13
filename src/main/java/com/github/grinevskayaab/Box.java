package com.github.grinevskayaab;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<F extends Fruit> {
    private final List<F> container = new ArrayList<>();

    public void addFruit(F fruit) {
        container.add(fruit);
    }


    private List<F> getContainer() {
        return container;
    }

    private void clearContainer() {
        container.clear();
    }

    public Float getWeight() {
        return container.stream()
                .map(F::getFruitWeight)
                .reduce(0f, Float::sum);
    }

    public Boolean compare(Box<? extends Fruit> otherBox) {
        return Objects.equals(otherBox.getWeight(), getWeight());
    }

    public void sprinkleFruit(Box<F> otherFruits) {
        container.addAll(otherFruits.getContainer());
        otherFruits.clearContainer();
    }


}
