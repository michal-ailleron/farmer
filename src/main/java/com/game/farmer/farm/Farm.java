package com.game.farmer.farm;

import com.game.farmer.farm.box.RabbitBox;
import com.game.farmer.farm.box.SheepBox;
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

    public Farm(FarmType farmType) {
        this.farmType = farmType;
    }

    protected void fillBoxes() {
        rabbitBox.fulfilledBox();
        sheepBox.fulfilledBox();
    }

    protected void clearBoxes() {
        rabbitBox.clearBox();
        sheepBox.clearBox();
    }
}