package com.rpg.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;

import com.rpg.constants.CommonConstants;

public class IntUtils {
    private static Integer ORIGINPOINT;
    private static Integer MAXIMUMPOINT;

    static {
        ORIGINPOINT = Integer.parseInt(PropertyUtils.getPropertyValue(CommonConstants.ORIGIN_POINT));
        MAXIMUMPOINT = Integer.parseInt(PropertyUtils.getPropertyValue(CommonConstants.MAXIMUM_POINT));
    }

    private IntUtils() {
    }

    private static final IntPredicate POSITIVE_PREDICATE = (num) -> num >= 0;
    private static final IntPredicate NUMBER_RANGE = (num) -> num >= 0 && num < 11;

    public static final IntPredicate COORDINATE_NUMBER_RANGE = (num) -> ((num >= ORIGINPOINT && num <= MAXIMUMPOINT));

    public static boolean isNegative(int number) {
        return POSITIVE_PREDICATE.and(NUMBER_RANGE).negate().test(number);
    }

    public static int generateRandomNumber(int inclusive, int exclusive) {
        return ThreadLocalRandom.current().nextInt(inclusive, exclusive);
    }
}
