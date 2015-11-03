package com.oleh.groovy.phone

import com.oleh.groovy.util.Rent
import groovy.transform.ToString

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
@ToString(includeFields = true, includeNames = true)
class Phone extends Rent {

    private Integer countOfCityMinutes
    private Integer countOfIntercityMinutes
    private Integer countOfMobileMinutes
    private Double cityRatePerMinute
    private Double intercityRatePerMinute
    private Double mobileRatePerMinute

    Phone(Integer countOfCityMinutes, Integer countOfIntercityMinutes, Integer countOfMobileMinutes, Double cityRatePerMinute, Double intercityRatePerMinute, Double mobileRatePerMinute) {
        this.countOfCityMinutes = countOfCityMinutes
        this.countOfIntercityMinutes = countOfIntercityMinutes
        this.countOfMobileMinutes = countOfMobileMinutes
        this.cityRatePerMinute = cityRatePerMinute
        this.intercityRatePerMinute = intercityRatePerMinute
        this.mobileRatePerMinute = mobileRatePerMinute
    }

    @Override
    Double calculate() {
        Double result = calculateResult()
        return result
    }

    private Double calculateResult() {
        Double result = this.countOfCityMinutes * this.cityRatePerMinute +
                        this.countOfIntercityMinutes * this.intercityRatePerMinute +
                        this.countOfMobileMinutes * this.mobileRatePerMinute
        return result
    }

}
