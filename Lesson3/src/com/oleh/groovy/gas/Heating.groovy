package com.oleh.groovy.gas

import com.oleh.groovy.util.Rent
import groovy.transform.ToString

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
@ToString(includeFields = true, includeNames = true)
class Heating extends Rent {

    private Double price
    private Double heatedArea
    private Integer personsCount

    private static final THREE_AND_LESS_PERSONS_PRICE = 1.22
    private static final GRATER_THEN_3_PERSONS_PRICE = 2.56

    private static final HEATED_AREA_60_AND_LESS = 12.69
    private static final HEATED_AREA_GREATER_60 = 15.68

    Heating(Double price, Double heatedArea, Integer personsCount) {
        this.price = price
        this.heatedArea = heatedArea
        this.personsCount = personsCount
    }

    @Override
    Double calculate() {
        Double result = calculateResult()
        return result
    }

    private Double calculateResult() {
        Double result
        priceCalculation()
        result = this.price * this.personsCount
        return result
    }

    private void priceCalculation() {
        if (this.heatedArea <= 60 && this.personsCount <= 3) {
            this.price = HEATED_AREA_60_AND_LESS + THREE_AND_LESS_PERSONS_PRICE
        } else if (this.heatedArea > 60 && this.personsCount <= 3) {
            this.price = HEATED_AREA_GREATER_60 + THREE_AND_LESS_PERSONS_PRICE
        } else if (this.heatedArea <= 60 && this.personsCount > 3) {
            this.price = HEATED_AREA_60_AND_LESS + GRATER_THEN_3_PERSONS_PRICE
        } else if (this.heatedArea > 60 && this.personsCount > 3) {
            this.price = HEATED_AREA_GREATER_60 + THREE_AND_LESS_PERSONS_PRICE
        }
    }

}
