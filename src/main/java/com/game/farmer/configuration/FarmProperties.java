package com.game.farmer.configuration;

import com.game.farmer.animals.AnimalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;

/**
 * <h1>FarmConfiguration</h1>
 * <br>
 * <p/>
 * Creation date: 01.03.2020
 *
 * @author miba <a href="http://www.ailleron.com">AILLERON S.A.</a>
 **/
@Configuration
@ConfigurationProperties(prefix = "farm")
@Setter
@Getter
public class FarmProperties {

    private BoxSize boxSize;
    private EnumMap<AnimalType, Integer> exchange;

    @Setter
    @Getter
    public static class BoxSize {
        private Integer rabbit;
        private Integer sheep;
        private Integer pig;
        private Integer cow;
        private Integer horse;
        private Integer smallDog;
        private Integer bigDog;
    }

    @Getter
    @Setter
    public static class Rabbit {
        private int size;
    }

    @Getter
    @Setter
    public static class Sheep {
        private int size;
    }

    @Getter
    @Setter
    public static class Pig {
        private int size;
    }

    @Getter
    @Setter
    public static class Cow {
        private int size;
    }

    @Getter
    @Setter
    public static class Horse {
        private int size;
    }

    @Getter
    @Setter
    public static class SmallDog {
        private int size;
    }

    @Getter
    @Setter
    public static class BigDog {
        private int size;
    }
}