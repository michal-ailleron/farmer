package com.game.farmer.exchange;

import com.game.farmer.animals.Animal;
import com.game.farmer.farm.Farm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h1>AnimalExchangeImpl</h1>
 * <br>
 * <p/>
 * Creation date: 11.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Component
public class AnimalExchangeImpl implements AnimalExchange {
    @Override
    public List<Animal> tradeView(final Farm farm) {
        return null;
    }
}