package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 16.11.15.
 */
class TestCar {

    private Integer serviceableCars = 0
    private Integer faultyCars = 0
    private static final BROKEN_ENGINE = 5

    public void checkCars(List<Car> cars) {
        cars.each {
            Boolean isOk = checkEngine(it.getEngine().getCheckedValue())
            if (isOk) serviceableCars++
            else faultyCars++
        }
    }

    private Boolean checkEngine(Integer checkedValue) {
        Boolean checkedResult = true
        if (checkedValue == BROKEN_ENGINE) {
            println 'Engine is broken!!!'
            checkedResult = false
        }
        return checkedResult
    }

    Integer getServiceableCars() {
        return serviceableCars
    }
    Integer getFaultyCars() {
        return faultyCars
    }
}
