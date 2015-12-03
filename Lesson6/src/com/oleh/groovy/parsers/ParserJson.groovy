package com.oleh.groovy.parsers

import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.Country
import com.oleh.groovy.fruits.Lemon
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * Created by oleh on 03.12.15.
 */
class ParserJson {

    public parse() {
        def slurper = new JsonSlurper()
        def appleJson = buildAppleJson()Json()
        def apple = slurper.parseText(appleJson as String)
        def lemon = JsonOutput.toJson(new Lemon(12.3, Color.YELLOW, false, 12.96, Country.UKRAINE))
        println apple
        println JsonOutput.prettyPrint(lemon)

    }

    private def buildAppleJson() {
        return '{"name": "apple", "weight": "12.36", "color": "GREEN", "pricePerKilo": "12.95", "countryFrom": "USA", "appleType": "FUJI"}'
    }

}
