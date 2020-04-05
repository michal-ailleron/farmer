package com.game.farmer.exchange;

import com.game.farmer.animals.AnimalType;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TradeBoxTest {

    @Test
    void to_object_are_equal_test() {
        //given
        final TradeBox firstTradeBox = TradeBox.of(1, AnimalType.SHEEP);
        final TradeBox secondTradeBox = TradeBox.of(1, AnimalType.SHEEP);
        //then
        assertEquals(firstTradeBox, secondTradeBox);
    }

    @Test
    void to_object_are_not_equal_test() {
        //given
        final TradeBox firstTradeBox = TradeBox.of(1, AnimalType.SHEEP);
        final TradeBox secondTradeBox = TradeBox.of(1, AnimalType.RABBIT);
        final TradeBox thirdTradeBox = TradeBox.of(1, AnimalType.SHEEP);
        final TradeBox forthTradeBox = TradeBox.of(2, AnimalType.SHEEP);
        //then
        assertNotEquals(firstTradeBox, secondTradeBox);
        assertNotEquals(thirdTradeBox, forthTradeBox);
    }

    @Test
    void map_key_test() {
        //given
        final TradeBox firstTradeBox = TradeBox.of(1, AnimalType.SHEEP);
        final TradeBox secondTradeBox = TradeBox.of(1, AnimalType.RABBIT);
        final Map<TradeBox, String> tradeMap = new HashMap<>();
        tradeMap.put(firstTradeBox, "First box value");
        tradeMap.put(secondTradeBox, "Second box value");
        //when
        String firstValue = tradeMap.get(TradeBox.of(1, AnimalType.SHEEP));
        String secondValue = tradeMap.get(TradeBox.of(1, AnimalType.RABBIT));
        //then
        StringUtils.isNotBlank(firstValue);
        StringUtils.isNotBlank(secondValue);
        assertEquals("First box value", firstValue);
        assertEquals("Second box value", secondValue);

        //when
        firstValue = tradeMap.get(TradeBox.of(1, AnimalType.SHEEP));
        secondValue = tradeMap.get(TradeBox.of(2, AnimalType.SHEEP));
        //then
        StringUtils.isNotBlank(firstValue);
        StringUtils.isBlank(secondValue);
        assertEquals("First box value", firstValue);
    }
}