package com.game.farmer.configuration;

import com.game.farmer.animals.*;
import com.game.farmer.dice.AbstractDice;
import com.game.farmer.dice.BlueDice;
import com.game.farmer.dice.RedDice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>DiceConfiguration</h1>
 * <br>
 * <p/>
 * Creation date: 29.02.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Configuration
public class DiceConfiguration {

    @Bean
    public Set<AbstractDice> dicesSet() {
        Set<AbstractDice> dices = new HashSet<>();
        dices.add(createRedDice());
        dices.add(createBlueDice());
        return dices;
    }

    private AbstractDice createBlueDice() {
        //blue dice (wolf, cow, pig, 3 sheeps, 6 rabbits),
        final List<Animal> blueContent = new ArrayList<>();
        blueContent.add(new Wolf());
        blueContent.add(new Cow());
        blueContent.add(new Pig());
        blueContent.addAll(createAnimals(new Sheep(), 3));
        blueContent.addAll(createAnimals(new Rabbit(), 6));

        return new BlueDice(blueContent);
    }

    private AbstractDice createRedDice() {
        //red dice (fox, horse, 2 pigs, 2 sheeps, 6 rabbits),
        final List<Animal> redContent = new ArrayList<>();
        redContent.add(new Fox());
        redContent.add(new Horse());
        redContent.addAll(createAnimals(new Pig(), 2));
        redContent.addAll(createAnimals(new Sheep(), 2));
        redContent.addAll(createAnimals(new Rabbit(), 6));

        return new RedDice(redContent);
    }


    private List<Animal> createAnimals(final Animal animal, int count) {
        final List<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            animalList.add(animal);
        }
        return animalList;
    }
}