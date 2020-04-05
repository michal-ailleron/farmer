package com.game.farmer.exchange;

import com.game.farmer.animals.AnimalType;
import com.game.farmer.configuration.FarmProperties;
import com.game.farmer.farm.Farm;
import com.game.farmer.farm.box.Box;
import com.game.farmer.farm.box.BoxType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>AnimalExchangeImpl</h1>
 * <br>
 * <p/>
 * Creation date: 11.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Component
@AllArgsConstructor
public class AnimalExchangeImpl implements AnimalExchange {

    private final FarmProperties farmProperties;

    @Override
    public Map<TradeBox, List<TradeBox>> tradeView(final Farm farm) {
        final Map<TradeBox, List<TradeBox>> preViewMap = new HashMap<>();

        for (final Map.Entry<BoxType, Box> farmBox : farm.getBoxMap().entrySet()) {
            final BoxType boxType = farmBox.getKey();
            if (BoxType.RABBIT == boxType) {
                calculateRabbitBox(preViewMap, farmBox.getValue());
            }
        }

        return preViewMap;
    }

    private void calculateRabbitBox(final Map<TradeBox, List<TradeBox>> preViewMap, final Box box) {
        final int rabbitCount = box.getAnimals().size();
        final TradeBox rabbitTradeBoxList = TradeBox.of(rabbitCount, AnimalType.RABBIT);
        final List<TradeBox> animalTradeBox = new ArrayList<>();

        for (final Map.Entry<AnimalType, Integer> exchange : farmProperties.getExchange().entrySet()) {
            final Integer exchangeValue = exchange.getValue();

            if (exchangeValue == null || exchangeValue.equals(0)){
                continue;
            }

            int animalCount = rabbitCount / exchangeValue;

            if (animalCount > 0) {
                animalTradeBox.add(TradeBox.of(animalCount, exchange.getKey()));
            }
        }

        preViewMap.put(rabbitTradeBoxList, animalTradeBox);
    }
}