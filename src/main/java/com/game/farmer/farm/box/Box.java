package com.game.farmer.farm.box;

import com.game.farmer.animals.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1>Box</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Getter
public abstract class Box<T extends Animal> {
    private final BoxType boxType;
    private final int size;
    private final List<T> animals;
    private final T animal;

    public Box(BoxType boxType, int size, final T animal) {
        this.boxType = boxType;
        this.size = size;
        this.animal = animal;
        this.animals = new ArrayList<>(size);
    }

    public void add() {
        if (animals.size() < size) {
            animals.add(animal);
        }
    }

    public void remove() {
        if (!animals.isEmpty()) {
            animals.remove(animals.size() - 1);
        }
    }

    public void fulfilledBox() {
        for (int i = 0; i < size; i++) {
            animals.add(animal);
        }
    }

    public void clearBox() {
        animals.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return boxType == box.boxType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxType);
    }
}