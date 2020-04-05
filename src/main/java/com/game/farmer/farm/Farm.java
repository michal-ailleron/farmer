package com.game.farmer.farm;

import com.game.farmer.farm.box.Box;
import com.game.farmer.farm.box.BoxType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public abstract class Farm {
    private final FarmType farmType;
    private final EnumMap<BoxType, Box> boxMap = new EnumMap<>(BoxType.class);

    public Farm(FarmType farmType) {
        this.farmType = farmType;
    }

    public void fillBoxes() {
        boxMap.forEach((boxType, box) -> box.fulfilledBox());
    }

    public void clearBoxes() {
        boxMap.forEach((boxType, box) -> box.clearBox());
    }

    public void addAnimalsToBox(final BoxType boxType, final int animalCount) {
        final Box box = boxMap.get(boxType);
        if(box == null){
            log.info("Farm not contain box: {}", boxType);
            return;
        }
        for (int i = 0; i < animalCount; i++) box.add();
    }
}