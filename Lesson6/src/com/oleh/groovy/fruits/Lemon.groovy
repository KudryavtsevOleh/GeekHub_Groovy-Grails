package com.oleh.groovy.fruits

import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.Country

/**
 * Created by oleh on 01.12.15.
 */
class Lemon extends Fruit {

    private Double weight
    private Color color
    private Boolean isSour
    private Double pricePerKilo
    private Country countryFrom

    Lemon(Double weight, Color color, Boolean isSour, Double pricePerKilo, Country countryFrom) {
        this.weight = weight
        this.color = color
        this.isSour = isSour
        this.pricePerKilo = pricePerKilo
        this.countryFrom = countryFrom
    }

    @Override
    Map getProperties() {
        def properties = [:]
        properties.weight = this.weight
        properties.color = this.color
        properties.isSour = this.isSour
        properties.pricePerKilo = this.pricePerKilo
        properties.countryFrom = this.countryFrom
        return properties
    }
}
