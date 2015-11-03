package com.oleh.groovy.util

import com.oleh.groovy.gas.Gas
import com.oleh.groovy.gas.Heating
import com.oleh.groovy.light.Light
import com.oleh.groovy.phone.Phone
import com.oleh.groovy.water.Water
import com.oleh.groovy.water.WaterType

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
class BuildObjects {

    private static List rent = []

    static void buildRent() {
        rent.add(new Gas(0.254, false, 0, new Date(2015, 12, 12), new Date(2015, 12, 13), 12, 13))
        rent.add(new Water(12.60, 3, 4.63, WaterType.HOT))
        rent.add(new Water(9.12, 3, 4.63, WaterType.COLD))
        rent.add(new Heating(12.58, 75, 4))
        rent.add(new Light(1258, 1152, 0.758))
        rent.add(new Phone(12, 0, 79, 0.58, 0.78, 1.25))
    }

    public static getRent() {
        return rent
    }

}
