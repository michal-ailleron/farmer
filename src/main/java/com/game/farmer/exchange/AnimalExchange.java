package com.game.farmer.exchange;

import com.game.farmer.animals.Animal;
import com.game.farmer.farm.Farm;

import java.util.List;

/**
 * <h1>AnimalExchange</h1>
 * <br>
 * <p/>
 * Creation date: 08.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public interface AnimalExchange {
    List<Animal> tradeView(final Farm farm);
}