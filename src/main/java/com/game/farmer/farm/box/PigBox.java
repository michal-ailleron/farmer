package com.game.farmer.farm.box;

import com.game.farmer.animals.Pig;

/**
 * <h1>PigBox</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class PigBox extends Box<Pig> {
    public PigBox(final int size) {
        super(BoxType.PIG, size, new Pig());
    }
}