package com.game.farmer.farm;

import com.game.farmer.configuration.FarmProperties;
import com.game.farmer.farm.box.BoxType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
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
        assertEquals(farmProperties.getRabbit().getSize(), mainFarm.getBoxMap().get(BoxType.RABBIT).getAnimals().size());
        assertEquals(farmProperties.getSheep().getSize(), mainFarm.getBoxMap().get(BoxType.SHEEP).getAnimals().size());
        assertEquals(farmProperties.getPig().getSize(), mainFarm.getBoxMap().get(BoxType.PIG).getAnimals().size());
        assertEquals(farmProperties.getCow().getSize(), mainFarm.getBoxMap().get(BoxType.COW).getAnimals().size());
        assertEquals(farmProperties.getHorse().getSize(), mainFarm.getBoxMap().get(BoxType.HORSE).getAnimals().size());
        assertEquals(farmProperties.getSmallDog().getSize(), mainFarm.getBoxMap().get(BoxType.SMALL_DOG).getAnimals().size());
        assertEquals(farmProperties.getBigDog().getSize(), mainFarm.getBoxMap().get(BoxType.BIG_DOG).getAnimals().size());
    }

    @Test
    void should_return_init_player_farm() {
        //given
        final Farm playerFarm = farmFactory.createPlayerFarm();
        //then
        assertEquals(0, playerFarm.getBoxMap().get(BoxType.RABBIT).getAnimals().size());
        assertEquals(0, playerFarm.getBoxMap().get(BoxType.SHEEP).getAnimals().size());
        assertEquals(0, playerFarm.getBoxMap().get(BoxType.PIG).getAnimals().size());
        assertEquals(0, playerFarm.getBoxMap().get(BoxType.COW).getAnimals().size());
        assertEquals(0, playerFarm.getBoxMap().get(BoxType.HORSE).getAnimals().size());
        assertEquals(0, playerFarm.getBoxMap().get(BoxType.SMALL_DOG).getAnimals().size());
        assertEquals(0, playerFarm.getBoxMap().get(BoxType.BIG_DOG).getAnimals().size());

    }

    private void assertBoxSize(Farm mainFarm) {
        assertEquals(farmProperties.getRabbit().getSize(), mainFarm.getBoxMap().get(BoxType.RABBIT).getSize());
        assertEquals(farmProperties.getSheep().getSize(), mainFarm.getBoxMap().get(BoxType.SHEEP).getSize());
        assertEquals(farmProperties.getPig().getSize(), mainFarm.getBoxMap().get(BoxType.PIG).getSize());
        assertEquals(farmProperties.getCow().getSize(), mainFarm.getBoxMap().get(BoxType.COW).getSize());
        assertEquals(farmProperties.getHorse().getSize(), mainFarm.getBoxMap().get(BoxType.HORSE).getSize());
        assertEquals(farmProperties.getSmallDog().getSize(), mainFarm.getBoxMap().get(BoxType.SMALL_DOG).getSize());
        assertEquals(farmProperties.getBigDog().getSize(), mainFarm.getBoxMap().get(BoxType.BIG_DOG).getSize());
    }
}