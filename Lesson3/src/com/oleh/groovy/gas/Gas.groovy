package com.oleh.groovy.gas

import com.oleh.groovy.util.Asserts
import com.oleh.groovy.util.Rent
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import groovy.transform.ToString

/**
 * Created by Oleh Kudryavcev on 02.11.15.
 */
@ToString(includeFields = true, includeNames = true)
class Gas extends Rent {

    private Double price
    private Boolean privileges
    private Double privilegesPercent
    private Double privilegesValue
    private Date payPriorToTheDate
    private Date payDate
    private Double surcharge = 0.0
    private Integer previousIndexCounter
    private Integer currentIndexCounter
    private static final Double SURCHARGE_PER_DAY = 0.521

    Gas(Double price, Boolean privileges, Double privilegesPercent, Date payPriorToTheDate, Date payDate, Integer previousIndexCounter, Integer currentIndexCounter) {
        this.price = price
        this.privileges = privileges
        this.privilegesPercent = privilegesPercent
        this.payPriorToTheDate = payPriorToTheDate
        this.payDate = payDate
        this.previousIndexCounter = previousIndexCounter
        this.currentIndexCounter = currentIndexCounter
    }

    @Override
    Double calculate() {
        Double result = calculateResult()
        return result
    }

    private Double calculateResult() {
        Double toPay
        Double counterPay
        Integer counterToPay = this.currentIndexCounter - this.previousIndexCounter
        Asserts.assertIndex(counterToPay, this.getClass())
        Integer duration = daysBetween(this.payPriorToTheDate, this.payDate)
        if (duration > 0) {
            this.surcharge = duration * SURCHARGE_PER_DAY
        }
        counterPay = counterToPay * this.price
        toPay = counterPay + this.surcharge
        if (Boolean.TRUE.equals(this.privileges)) {
            this.privilegesValue = toPay * (this.privilegesPercent / 100)
            toPay -= this.privilegesValue
        }
        return toPay
    }

    private Integer daysBetween(Date startDate, Date endDate) {
        use(TimeCategory) {
            def duration = endDate - startDate
            return duration.days
        }
    }

}
