package com.game.farmer.animals;

import lombok.Getter;

/**
 * <h1>Rabbit</h1>
 * <br>
 * <p/>
 * Creation date: 29.02.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Getter
public class Rabbit extends Animal {
    public Rabbit() {
        super(AnimalType.RABBIT);
    }
}