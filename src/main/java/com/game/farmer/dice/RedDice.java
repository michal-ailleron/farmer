package com.game.farmer.dice;

import com.game.farmer.animals.Animal;

import java.util.List;

/**
 * <h1>RedDice</h1>
 * <br>
 * <p/>
 * Creation date: 29.02.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class RedDice extends AbstractDice {

    public RedDice(final List<Animal> diceContent) {
        super(diceContent, DiceType.RED);
    }
}