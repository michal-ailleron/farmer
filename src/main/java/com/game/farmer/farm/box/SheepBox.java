package com.game.farmer.farm.box;

import com.game.farmer.animals.Sheep;

/**
 * <h1>RabbitBox</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class SheepBox extends Box<Sheep> {
    public SheepBox(final int size) {
        super(BoxType.SHEEP, size, new Sheep());
    }
}