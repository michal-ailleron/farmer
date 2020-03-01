package com.game.farmer;

import com.game.farmer.animals.Animal;
import com.game.farmer.animals.AnimalType;
import com.game.farmer.configuration.FarmProperties;
import com.game.farmer.dice.AbstractDice;
import com.game.farmer.dice.DiceType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource("classpath:application-test.yaml")
class FarmerApplicationTests {

    @Autowired
    private Set<AbstractDice> dices;

    @Autowired
    private FarmProperties farmProperties;

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
        assertTrue(redDice.isPresent());
        final List<Animal> diceContent = redDice.get().getDiceContent();

        assertEquals(1, countAnimal(diceContent, AnimalType.FOX));
        assertEquals(1, countAnimal(diceContent, AnimalType.HORSE));
        assertEquals(2, countAnimal(diceContent, AnimalType.PIG));
        assertEquals(2, countAnimal(diceContent, AnimalType.SHEEP));
        assertEquals(6, countAnimal(diceContent, AnimalType.RABBIT));

    }

    @Test
    void blue_dice_should_contains_corrects_animals() {
        //when
        final Optional<AbstractDice> redDice = dices.stream()
                .filter(i -> DiceType.BLUE == i.getDiceType())
                .findFirst();
        //then
        assertTrue(redDice.isPresent());
        final List<Animal> diceContent = redDice.get().getDiceContent();

        assertEquals(1, countAnimal(diceContent, AnimalType.WOLF));
        assertEquals(1, countAnimal(diceContent, AnimalType.COW));
        assertEquals(1, countAnimal(diceContent, AnimalType.PIG));
        assertEquals(3, countAnimal(diceContent, AnimalType.SHEEP));
        assertEquals(6, countAnimal(diceContent, AnimalType.RABBIT));

    }


    @Test
    void farm_properties_load_test() {
        assertEquals(60, farmProperties.getRabbit().getSize(), "Incorrectly bound rabbit.size property");
        assertEquals(24, farmProperties.getSheep().getSize(), "Incorrectly bound sheep.size property");
        assertEquals(20, farmProperties.getPig().getSize(), "Incorrectly bound pig.size property");
        assertEquals(12, farmProperties.getCow().getSize(), "Incorrectly bound cow.size property");
        assertEquals(6, farmProperties.getHorse().getSize(), "Incorrectly bound horse.size property");
        assertEquals(4, farmProperties.getSmallDog().getSize(), "Incorrectly bound small-dog.size property");
        assertEquals(2, farmProperties.getBigDog().getSize(), "Incorrectly bound big-dog.size property");
    }

    private long countAnimal(final List<Animal> animals, final AnimalType animalType) {
        return animals.stream()
                .filter(i -> animalType == i.getAnimalType())
                .count();
    }
}
