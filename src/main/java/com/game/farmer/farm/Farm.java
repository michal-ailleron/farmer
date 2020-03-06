package com.game.farmer.farm;

import com.game.farmer.farm.box.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>Farm</h1>
 * <br>
 * <p/>
 * Creation date: 29.02.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Getter
@Setter
public abstract class Farm {
    private final FarmType farmType;
    private RabbitBox rabbitBox;
    private SheepBox sheepBox;
    private PigBox pigBox;
    private CowBox cowBox;
    private HorseBox horseBox;
    private SmallDogBox smallDogBox;
    private BigDogBox bigDogBox;

    public Farm(FarmType farmType) {
        this.farmType = farmType;
    }

    protected void fillBoxes() {
        rabbitBox.fulfilledBox();
        sheepBox.fulfilledBox();
        pigBox.fulfilledBox();
        cowBox.fulfilledBox();
        horseBox.fulfilledBox();
        smallDogBox.fulfilledBox();
        bigDogBox.fulfilledBox();

    }

    protected void clearBoxes() {
        rabbitBox.clearBox();
        sheepBox.clearBox();
        pigBox.clearBox();
        cowBox.clearBox();
        horseBox.clearBox();
        smallDogBox.clearBox();
        bigDogBox.clearBox();
    }
}