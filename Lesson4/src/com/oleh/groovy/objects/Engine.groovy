package com.oleh.groovy.objects

/**
 * Created by oleh on 16.11.15.
 */
class Engine {

    private Integer power
    private Double fuelValue
    private Integer checkedValue

    Engine(Integer power, Double fuelValue, Integer checkedValue) {
        this.power = power
        this.fuelValue = fuelValue
        this.checkedValue = checkedValue
    }

    Integer getPower() {
        return power
    }
    void setPower(Integer power) {
        this.power = power
    }

    Double getFuelValue() {
        return fuelValue
    }
    void setFuelValue(Double fuelValue) {
        this.fuelValue = fuelValue
    }

    Integer getCheckedValue() {
        return checkedValue
    }
    void setCheckedValue(Integer checkedValue) {
        this.checkedValue = checkedValue
    }
}
