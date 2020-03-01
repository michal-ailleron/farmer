package com.game.farmer.dice;

import com.game.farmer.animals.Animal;
import com.game.farmer.exceptions.DiceContentException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Random;

/**
 * <h1>AbstractDice</h1>
 * <br>
 * <p/>
 * Creation date: 29.02.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Getter
@AllArgsConstructor
public abstract class AbstractDice {
    final List<Animal> diceContent;
    final DiceType diceType;

    public Animal rollDice() throws DiceContentException {
        if (CollectionUtils.isEmpty(diceContent)) {
            throw new DiceContentException("Dice content cannot be empty");
        }

        return diceContent.get(new Random().nextInt(diceContent.size()));
    }
}