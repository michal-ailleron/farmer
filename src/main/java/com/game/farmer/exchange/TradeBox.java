package com.game.farmer.exchange;

import com.game.farmer.animals.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * <h1>TradeBox</h1>
 * <br>
 * <p/>
 * Creation date: 15.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Getter
@AllArgsConstructor(staticName = "of")
public class TradeBox {
    private int animalCount;
    private AnimalType animalType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeBox tradeBox = (TradeBox) o;
        return animalCount == tradeBox.animalCount &&
                animalType == tradeBox.animalType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalCount, animalType);
    }
}