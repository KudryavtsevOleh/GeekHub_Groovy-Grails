package com.oleh.groovy.light

import com.oleh.groovy.util.Asserts
import com.oleh.groovy.util.Rent
import groovy.transform.ToString

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
@ToString(includeFields = true, includeNames = true)
class Light extends Rent {

    private Integer currentIndexCounter
    private Integer previousIndexCounter
    private Double wattPrice

    Light(Integer currentIndexCounter, Integer previousIndexCounter, Double wattPrice) {
        this.currentIndexCounter = currentIndexCounter
        this.previousIndexCounter = previousIndexCounter
        this.wattPrice = wattPrice
    }

    @Override
    Double calculate() {
        Double result = calculateResult()
        return result
    }

    private Double calculateResult() {
        Integer counterToPay = this.currentIndexCounter - this.previousIndexCounter
        Asserts.assertIndex(counterToPay, this.getClass())
        Double result = counterToPay * this.wattPrice
        return result
    }

}
