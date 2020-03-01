package com.game.farmer.dice;

import com.game.farmer.animals.Animal;

import java.util.List;

/**
 * <h1>BlueDice</h1>
 * <br>
 * <p/>
 * Creation date: 29.02.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class BlueDice extends AbstractDice {
    public BlueDice(final List<Animal> diceContent) {
        super(diceContent, DiceType.BLUE);
    }
}