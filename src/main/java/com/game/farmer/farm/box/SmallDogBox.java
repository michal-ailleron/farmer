package com.game.farmer.farm.box;

import com.game.farmer.animals.SmallDog;

/**
 * <h1>SmallDogBox</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class SmallDogBox extends Box<SmallDog> {
    public SmallDogBox(final int size) {
        super(BoxType.SMALL_DOG, size, new SmallDog());
    }
}