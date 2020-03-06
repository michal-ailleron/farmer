package com.game.farmer.farm.box;

import com.game.farmer.animals.Horse;

/**
 * <h1>HorseBox</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class HorseBox extends Box<Horse> {
    public HorseBox(final int size) {
        super(BoxType.HORSE, size, new Horse());
    }
}