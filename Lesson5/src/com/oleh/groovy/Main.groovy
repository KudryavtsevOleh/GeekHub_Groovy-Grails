package com.oleh.groovy

import com.oleh.groovy.duck.DuckWithDef
import com.oleh.groovy.duck.DuckWithoutDef
import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.DuckBreed

/**
 * Created by Oleh Kudryavcev on 23.11.15.
 */
class Main {

    private static List ducks = []

    static {
        ducks << new DuckWithDef(12, 23, 12.67, 1.5)
        ducks << new DuckWithDef(Color.BLACK_AND_WHITE, DuckBreed.AMERICAN_PEKIN_DUCK, true, {val -> val + 3})
        ducks << new DuckWithDef('duck', Color.BLACK_AND_WHITE, DuckBreed.BAU_DUCK, '1.5')
        ducks << new DuckWithoutDef(Color.WHITE, DuckBreed.ABACOT_RANGER, 1.45, 12.45)
    }

    public static void main(String[] args) {
        ducks.each { println it }
    }

}
