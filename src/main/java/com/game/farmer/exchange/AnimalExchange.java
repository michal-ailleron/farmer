package com.game.farmer.exchange;

import com.game.farmer.farm.Farm;

import java.util.List;
import java.util.Map;

/**
 * <h1>AnimalExchange</h1>
 * <br>
 * <p/>
 * Creation date: 08.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public interface AnimalExchange {
    Map<TradeBox,List<TradeBox>> tradeView(final Farm farm);
}