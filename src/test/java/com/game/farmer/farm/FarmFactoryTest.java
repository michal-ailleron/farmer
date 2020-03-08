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
    void check_farms_box_size() {
        //when
        final Farm mainFarm = farmFactory.createMainFarm();
        final Farm playerFarm = farmFactory.createPlayerFarm();
        //then
        assertBoxSize(mainFarm);
        assertBoxSize(playerFarm);
    }

    @Test
    void return_filled_box_with_animals_for_main_farm() {
        //given
        final Farm mainFarm = farmFactory.createMainFarm();
        //then
        assertEquals(farmProperties.getBoxSize().getRabbit(), mainFarm.getRabbitBox().getAnimals().size());
        assertEquals(farmProperties.getBoxSize().getSheep(), mainFarm.getSheepBox().getAnimals().size());
        assertEquals(farmProperties.getBoxSize().getPig(), mainFarm.getPigBox().getAnimals().size());
        assertEquals(farmProperties.getBoxSize().getCow(), mainFarm.getCowBox().getAnimals().size());
        assertEquals(farmProperties.getBoxSize().getHorse(), mainFarm.getHorseBox().getAnimals().size());
        assertEquals(farmProperties.getBoxSize().getSmallDog(), mainFarm.getSmallDogBox().getAnimals().size());
        assertEquals(farmProperties.getBoxSize().getBigDog(), mainFarm.getBigDogBox().getAnimals().size());
    }

    @Test
    void should_return_init_player_farm() {
        //given
        final Farm playerFarm = farmFactory.createPlayerFarm();
        //then
        assertEquals(0, playerFarm.getRabbitBox().getAnimals().size());
        assertEquals(0, playerFarm.getSheepBox().getAnimals().size());
        assertEquals(0, playerFarm.getPigBox().getAnimals().size());
        assertEquals(0, playerFarm.getCowBox().getAnimals().size());
        assertEquals(0, playerFarm.getHorseBox().getAnimals().size());
        assertEquals(0, playerFarm.getSmallDogBox().getAnimals().size());
        assertEquals(0, playerFarm.getBigDogBox().getAnimals().size());

    }

    private void assertBoxSize(Farm mainFarm) {
        assertEquals(farmProperties.getBoxSize().getRabbit(), mainFarm.getRabbitBox().getSize());
        assertEquals(farmProperties.getBoxSize().getSheep(), mainFarm.getSheepBox().getSize());
        assertEquals(farmProperties.getBoxSize().getPig(), mainFarm.getPigBox().getSize());
        assertEquals(farmProperties.getBoxSize().getCow(), mainFarm.getCowBox().getSize());
        assertEquals(farmProperties.getBoxSize().getHorse(), mainFarm.getHorseBox().getSize());
        assertEquals(farmProperties.getBoxSize().getSmallDog(), mainFarm.getSmallDogBox().getSize());
        assertEquals(farmProperties.getBoxSize().getBigDog(), mainFarm.getBigDogBox().getSize());
    }
}