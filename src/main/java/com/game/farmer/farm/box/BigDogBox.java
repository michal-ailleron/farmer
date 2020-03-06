package com.game.farmer.farm.box;

import com.game.farmer.animals.BigDog;

/**
 * <h1>BigDogBox</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class BigDogBox extends Box<BigDog> {
    public BigDogBox(final int size) {
        super(BoxType.BIG_DOG, size, new BigDog());
    }
}