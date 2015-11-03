package com.oleh.groovy.util

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
class Calculate {

    public static Double calculate(Rent rent) {
        Double result = rent.calculate()
        return result
    }

    public static Double validate(Rent rent) {
        Double result = calculate(rent)
        return result
    }

}
