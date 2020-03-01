package com.game.farmer.farm.box;

import com.game.farmer.animals.Rabbit;

/**
 * <h1>RabbitBox</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
public class RabbitBox extends Box<Rabbit> {
    public RabbitBox(final int size) {
        super(BoxType.RABBIT, size, new Rabbit());
    }
}