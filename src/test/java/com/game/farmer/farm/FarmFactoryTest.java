package com.game.farmer.farm;

import com.game.farmer.configuration.FarmProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("classpath:application-test.yaml")
class FarmFactoryTest {

    @Autowired
    private FarmFactory farmFactory;
    @Autowired
    private FarmProperties farmProperties;

    @Test
    void should_return_correct_farm_type() {
        //when
        final Farm mainFarm = farmFactory.createMainFarm();
        final Farm playerFarm = farmFactory.createPlayerFarm();
        //then
        assertEquals(FarmType.MAIN, mainFarm.getFarmType());
        assertEquals(FarmType.PLAYER, playerFarm.getFarmType());
    }

    @Test
    void return_filled_box_for_main_farm() {
        //when
        final Farm mainFarm = farmFactory.createMainFarm();
        //then
        assertEquals(farmProperties.getRabbit().getSize(), mainFarm.getRabbitBox().getSize());
        assertEquals(farmProperties.getSheep().getSize(), mainFarm.getSheepBox().getSize());
        assertEquals(farmProperties.getPig().getSize(), mainFarm.getPigBox().getSize());
        assertEquals(farmProperties.getCow().getSize(), mainFarm.getCowBox().getSize());
        assertEquals(farmProperties.getHorse().getSize(), mainFarm.getHorseBox().getSize());
        assertEquals(farmProperties.getSmallDog().getSize(), mainFarm.getSmallDogBox().getSize());
        assertEquals(farmProperties.getBigDog().getSize(), mainFarm.getBigDogBox().getSize());
    }
}