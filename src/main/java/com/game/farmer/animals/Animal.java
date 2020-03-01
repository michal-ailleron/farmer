package com.game.farmer.animals;

import lombok.Getter;

import java.util.Objects;

/**
 * <h1>Animal</h1>
 * <br>
 * <p/>
 * Creation date: 29.02.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Getter
public abstract class Animal {
    private final AnimalType animalType;

    public Animal(final AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalType == animal.animalType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalType);
    }
}