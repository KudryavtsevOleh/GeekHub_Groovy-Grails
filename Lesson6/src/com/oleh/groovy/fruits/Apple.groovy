package com.oleh.groovy.fruits

import com.oleh.groovy.enums.AppleType
import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.Country

/**
 * Created by oleh on 01.12.15.
 */
class Apple extends Fruit {

    private Double weight
    private Color color
    private Double pricePerKilo
    private Country countryFrom
    private AppleType appleType

    Apple(Double weight, Color color, Double pricePerKilo, Country countryFrom, AppleType appleType) {
        this.weight = weight
        this.color = color
        this.pricePerKilo = pricePerKilo
        this.countryFrom = countryFrom
        this.appleType = appleType
    }

    @Override
    Map getProperties() {
        def properties = [:]
        properties.weight = this.weight
        properties.color = this.color
        properties.appleType = this.appleType
        properties.pricePerKilo = this.pricePerKilo
        properties.countryFrom = this.countryFrom
        properties
    }
}
