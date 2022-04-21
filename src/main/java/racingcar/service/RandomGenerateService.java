package racingcar.service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerateService {
    private static final Integer MAX_NUMBER_RANGE = 9+1;
    private static final Integer MIN_NUMBER_RANGE = 0;

    public static Integer generateRandomInteger(){
        Integer result = -1;
        result = ThreadLocalRandom.current().nextInt(MIN_NUMBER_RANGE,MAX_NUMBER_RANGE) ;
        return result;
    }
}
