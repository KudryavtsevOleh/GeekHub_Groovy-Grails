package com.oleh.groovy.util

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
class Calculate {

    public static Double calculate(Rent rent) {
        return rent.calculate()
    }

    public static Double validate(Rent rent) {
        return calculate(rent)
    }

}
