package com.game.farmer.farm.box;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoxTest {


    @Test
    void when_list_has_been_fulfilled_then_size_not_empty() {
        //given
        final int size = 60;
        final Box rabbitBox = new RabbitBox(size);
        assertTrue(rabbitBox.getAnimals().isEmpty());
        //when
        rabbitBox.fulfilledBox();
        //then
        assertEquals(size, rabbitBox.getAnimals().size());
    }

    @Test
    void when_box_full_then_not_increase() {
        //given
        final int size = 60;
        final Box rabbitBox = new RabbitBox(size);
        rabbitBox.fulfilledBox();
        //when
        rabbitBox.add();
        rabbitBox.add();
        rabbitBox.add();
        //then
        assertEquals(size, rabbitBox.getAnimals().size());
    }

    @Test
    void should_remove_element_from_list() {
        //given
        final int size = 3;
        final Box rabbitBox = new RabbitBox(size);
        rabbitBox.fulfilledBox();
        //when
        rabbitBox.remove();
        assertEquals(2, rabbitBox.getAnimals().size());
        rabbitBox.remove();
        assertEquals(1, rabbitBox.getAnimals().size());
        rabbitBox.remove();
        assertEquals(0, rabbitBox.getAnimals().size());
        rabbitBox.remove();
        assertEquals(0, rabbitBox.getAnimals().size());
    }
}