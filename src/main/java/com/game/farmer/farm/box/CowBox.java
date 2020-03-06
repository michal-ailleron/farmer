package com.game.farmer.farm.box;

import com.game.farmer.animals.Cow;

/**
 * <h1>CowBox</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class CowBox extends Box<Cow> {
    public CowBox(final int size) {
        super(BoxType.COW, size, new Cow());
    }
}