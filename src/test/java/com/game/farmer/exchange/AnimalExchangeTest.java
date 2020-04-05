package com.game.farmer.exchange;

import com.game.farmer.animals.AnimalType;
import com.game.farmer.farm.Farm;
import com.game.farmer.farm.FarmFactory;
import com.game.farmer.farm.box.BoxType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
class AnimalExchangeTest {

    @Autowired
    private AnimalExchange animalExchange;
    @Autowired
    private FarmFactory farmFactory;

    private Farm mainFarm;
    private Farm playerFarm;

    @BeforeEach
    void setUp() {
        mainFarm = farmFactory.createMainFarm();
        playerFarm = farmFactory.createPlayerFarm();
    }

    @Test
    void should_return_one_sheep_and_one_small_dog_when_rabbits_range_is_six_to_eleven() {
        for (int i = 6; i < 11; i++) {
            //given
            playerFarm.clearBoxes();
            playerFarm.addAnimalsToBox(BoxType.RABBIT, i);
            //when
            Map<TradeBox, List<TradeBox>> tradeView = animalExchange.tradeView(playerFarm);
            //then
            assertFalse(tradeView.isEmpty());
            assertSixToElevenRange(tradeView.get(TradeBox.of(i, AnimalType.RABBIT)));
        }
    }

    private void assertSixToElevenRange(final List<TradeBox> tradeBoxList) {
        assertEquals(2, tradeBoxList.size());
        assertThat(tradeBoxList, hasItems(
                hasProperty("animalType", is(AnimalType.SHEEP)),
                hasProperty("animalCount", is(1)),
                hasProperty("animalType", is(AnimalType.SMALL_DOG)),
                hasProperty("animalCount", is(1))
        ));
    }

    @Test
    void should_return_sheep_small_dogs_and_one_pig_when_rabbits_range_is_twelve_to_thirty_five() {
        for (int i = 12; i < 35; i++) {
            //given
            playerFarm.clearBoxes();
            playerFarm.addAnimalsToBox(BoxType.RABBIT, i);
            //when
            Map<TradeBox, List<TradeBox>> tradeView = animalExchange.tradeView(playerFarm);
            //then
            assertFalse(tradeView.isEmpty());
            assertTwelveToThirtyFiveRange(tradeView.get(TradeBox.of(i, AnimalType.RABBIT)), i);
        }
    }

    private void assertTwelveToThirtyFiveRange(final List<TradeBox> tradeBoxList, int i) {
        assertEquals(3, tradeBoxList.size());
        assertThat(tradeBoxList, hasItems(
                hasProperty("animalType", is(AnimalType.SHEEP)),
                hasProperty("animalCount", is(i / 6)),
                hasProperty("animalType", is(AnimalType.SMALL_DOG)),
                hasProperty("animalCount", is(i / 6)),
                hasProperty("animalType", is(AnimalType.PIG)),
                hasProperty("animalCount", is(i / 12))
        ));
    }

    @Test
    void should_return_sheep_small_dogs_pigs_one_cow_and_big_dog_when_rabbits_range_is_thirty_six_to_sixty() {
        for (int i = 36; i < 60; i++) {
            //given
            playerFarm.clearBoxes();
            playerFarm.addAnimalsToBox(BoxType.RABBIT, i);
            //when
            Map<TradeBox, List<TradeBox>> tradeView = animalExchange.tradeView(playerFarm);
            //then
            assertFalse(tradeView.isEmpty());
            assertThirtySixToSixtyRange(tradeView.get(TradeBox.of(i, AnimalType.RABBIT)), i);
        }
    }

    private void assertThirtySixToSixtyRange(final List<TradeBox> tradeBoxList, int i) {
        assertEquals(5, tradeBoxList.size());
        assertThat(tradeBoxList, hasItems(
                hasProperty("animalType", is(AnimalType.SHEEP)),
                hasProperty("animalCount", is(i / 6)),
                hasProperty("animalType", is(AnimalType.SMALL_DOG)),
                hasProperty("animalCount", is(i / 6)),
                hasProperty("animalType", is(AnimalType.PIG)),
                hasProperty("animalCount", is(i / 12)),
                hasProperty("animalType", is(AnimalType.COW)),
                hasProperty("animalCount", is(i / 36)),
                hasProperty("animalType", is(AnimalType.BIG_DOG)),
                hasProperty("animalCount", is(i / 36))
        ));
    }
}