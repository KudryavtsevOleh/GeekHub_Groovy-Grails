package com.oleh.groovy.water

import com.oleh.groovy.util.Rent
import groovy.transform.ToString

/**
 * Created by oleh on 02.11.15.
 */
@ToString(includeFields = true, includeNames = true)
class Water extends Rent {

    private Double tariff
    private Integer peoplesCount
    private Double ratePerPerson
    private WaterType waterType

    Water(Double tariff, Integer peoplesCount, Double ratePerPerson, WaterType waterType) {
        this.tariff = tariff
        this.peoplesCount = peoplesCount
        this.ratePerPerson = ratePerPerson
        this.waterType = waterType
    }

    @Override
    Double calculate() {
        return calculateResult()
    }

    private Double calculateResult() {
        Double consumedTogether = this.peoplesCount * this.ratePerPerson
        Double result = consumedTogether * tariff
        return result
    }

}
