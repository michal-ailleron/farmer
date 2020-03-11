package com.game.farmer.farm;

import com.game.farmer.farm.box.Box;
import com.game.farmer.farm.box.BoxType;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;

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
    private final EnumMap<BoxType, Box> boxMap = new EnumMap<>(BoxType.class);

    public Farm(FarmType farmType) {
        this.farmType = farmType;
    }

    protected void fillBoxes() {
        boxMap.forEach((boxType, box) -> box.fulfilledBox());
    }

    protected void clearBoxes() {
        boxMap.forEach((boxType, box) -> box.clearBox());
    }
}