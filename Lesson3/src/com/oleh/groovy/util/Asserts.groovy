package com.oleh.groovy.util

import com.oleh.groovy.util.exceptions.CalculationException
import com.oleh.groovy.util.exceptions.CounterException

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
class Asserts {

    static void assertIndex(Integer indexCount, Class clazz) {
        if (indexCount < 0) {
            throw new CounterException("Invalid count value of " + clazz.getSimpleName())
        }
    }

    static void assertRentPrice(Double rentValue, Double checkValue) {
        if (!Objects.equals(rentValue, checkValue)) {
            throw new CalculationException("Different values for rent calculation!!!")
        }
    }

}
