package com.game.farmer.exchange;

import com.game.farmer.farm.Farm;
import com.game.farmer.farm.FarmFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

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
    void should_return_one_sheep() {
        //given

    }
}