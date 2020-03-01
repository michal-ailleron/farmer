package com.game.farmer;

import com.game.farmer.animals.Animal;
import com.game.farmer.animals.AnimalType;
import com.game.farmer.dice.AbstractDice;
import com.game.farmer.dice.DiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class FarmerApplicationTests {

    @Autowired
    private Set<AbstractDice> dices;

    @Test
    void contextLoads() {
    }

    @Test
    void red_dice_should_contains_corrects_animals() {
        //when
        final Optional<AbstractDice> redDice = dices.stream()
                .filter(i -> DiceType.RED == i.getDiceType())
                .findFirst();
        //then
        Assertions.assertTrue(redDice.isPresent());
        final List<Animal> diceContent = redDice.get().getDiceContent();

        Assertions.assertEquals(1, countAnimal(diceContent, AnimalType.FOX));
        Assertions.assertEquals(1, countAnimal(diceContent, AnimalType.HORSE));
        Assertions.assertEquals(2, countAnimal(diceContent, AnimalType.PIG));
        Assertions.assertEquals(2, countAnimal(diceContent, AnimalType.SHEEP));
        Assertions.assertEquals(6, countAnimal(diceContent, AnimalType.RABBIT));

    }

    @Test
    void blue_dice_should_contains_corrects_animals() {
        //when
        final Optional<AbstractDice> redDice = dices.stream()
                .filter(i -> DiceType.BLUE == i.getDiceType())
                .findFirst();
        //then
        Assertions.assertTrue(redDice.isPresent());
        final List<Animal> diceContent = redDice.get().getDiceContent();

        Assertions.assertEquals(1, countAnimal(diceContent, AnimalType.WOLF));
        Assertions.assertEquals(1, countAnimal(diceContent, AnimalType.COW));
        Assertions.assertEquals(1, countAnimal(diceContent, AnimalType.PIG));
        Assertions.assertEquals(3, countAnimal(diceContent, AnimalType.SHEEP));
        Assertions.assertEquals(6, countAnimal(diceContent, AnimalType.RABBIT));

    }

    private long countAnimal(final List<Animal> animals, final AnimalType animalType) {
        return animals.stream()
                .filter(i -> animalType == i.getAnimalType())
                .count();
    }
}
