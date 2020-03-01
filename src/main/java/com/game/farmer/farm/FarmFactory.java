package com.game.farmer.farm;

import com.game.farmer.configuration.FarmProperties;
import com.game.farmer.farm.box.RabbitBox;
import com.game.farmer.farm.box.SheepBox;
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
        final Farm mainFarm = createFarm(new MainFarm());
        mainFarm.fillBoxes();

        return mainFarm;
    }

    public Farm createPlayerFarm() {
        final Farm playerFarm = createFarm(new PlayerFarm());
        playerFarm.clearBoxes();

        return playerFarm;
    }

    private Farm createFarm(final Farm farm) {
        return new FarmBuilder(farm)
                .rabbitBox(farmProperties.getRabbit().getSize())
                .sheepBox(farmProperties.getSheep().getSize())
                .build();
    }


    public static class FarmBuilder {
        private Farm farm;

        public FarmBuilder(Farm farm) {
            this.farm = farm;
        }

        public FarmBuilder rabbitBox(int size) {
            this.farm.setRabbitBox(new RabbitBox(size));
            return this;
        }

        public FarmBuilder sheepBox(int size) {
            this.farm.setSheepBox(new SheepBox(size));
            return this;
        }

        public Farm build() {
            return this.farm;
        }
    }

}