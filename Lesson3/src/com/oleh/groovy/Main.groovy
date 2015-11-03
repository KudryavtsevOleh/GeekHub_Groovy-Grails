package com.oleh.groovy

import com.oleh.groovy.util.Asserts
import com.oleh.groovy.util.BuildObjects
import com.oleh.groovy.util.Calculate
import com.oleh.groovy.util.Rent

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
class Main {

    static {
        BuildObjects.buildRent()
    }

    static void main(String... args) {
        List rent = BuildObjects.getRent()
        rent.each {println it}
        printRent(rent)
    }

    private static void printRent(List rent) {
        rent.each {
            validateRent(it as Rent)
            println it.getClass().getSimpleName() + ' ' + Calculate.calculate(it as Rent)
        }
    }

    private static void validateRent(Rent rent) {
        Double rentValue = rent.calculate()
        Double checkValue = Calculate.validate(rent)
        Asserts.assertRentPrice(rentValue, checkValue)
    }

}
