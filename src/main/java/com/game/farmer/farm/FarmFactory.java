package com.game.farmer.farm;

import com.game.farmer.configuration.FarmProperties;
import com.game.farmer.farm.box.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <h1>FarmFactory</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Component
@AllArgsConstructor
public class FarmFactory {
    private final FarmProperties farmProperties;

    public Farm createMainFarm() {
        final Farm mainFarm = new MainFarm();
        setFarmBoxSize(mainFarm);
        mainFarm.fillBoxes();

        return mainFarm;
    }

    public Farm createPlayerFarm() {
        final Farm playerFarm = new PlayerFarm();
        setFarmBoxSize(playerFarm);

        return playerFarm;
    }

    private void setFarmBoxSize(final Farm farm) {
        farm.getBoxMap().put(BoxType.RABBIT, new RabbitBox(farmProperties.getBoxSize().getRabbit()));
        farm.getBoxMap().put(BoxType.SHEEP, new SheepBox(farmProperties.getBoxSize().getSheep()));
        farm.getBoxMap().put(BoxType.PIG, new PigBox(farmProperties.getBoxSize().getPig()));
        farm.getBoxMap().put(BoxType.COW, new CowBox(farmProperties.getBoxSize().getCow()));
        farm.getBoxMap().put(BoxType.HORSE, new HorseBox(farmProperties.getBoxSize().getHorse()));
        farm.getBoxMap().put(BoxType.SMALL_DOG, new SmallDogBox(farmProperties.getBoxSize().getSmallDog()));
        farm.getBoxMap().put(BoxType.BIG_DOG, new BigDogBox(farmProperties.getBoxSize().getBigDog()));
    }
}