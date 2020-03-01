package com.game.farmer.dice;

import com.game.farmer.animals.*;
import com.game.farmer.exceptions.DiceContentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class AbstractDiceTest {

    @Test
    void when_dice_content_empty_or_null_then_exception() {
        //given
        final List<Animal> emptyAnimalList = Collections.emptyList();
        final AbstractDice redDice = new RedDice(null);
        final AbstractDice blueDice = new BlueDice(emptyAnimalList);
        //then
        Assertions.assertThrows(DiceContentException.class, () -> redDice.rollDice());
        Assertions.assertThrows(DiceContentException.class, () -> blueDice.rollDice());
    }

    @Test
    void should_contain_correct_animal_when_roll() throws DiceContentException {
        //given
        final List<Animal> redDiceContent = Arrays.asList(new Rabbit(), new Sheep(), new Pig());
        final AbstractDice redDice = new RedDice(redDiceContent);
        //when
        final Animal animal = redDice.rollDice();
        //then
        Assertions.assertTrue(redDiceContent.contains(animal));
    }
}