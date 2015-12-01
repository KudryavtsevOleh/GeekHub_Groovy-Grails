package com.oleh.groovy

import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.Country
import com.oleh.groovy.fruits.Fruit
import com.oleh.groovy.fruits.Lemon
import com.oleh.groovy.generator.Generator
import com.oleh.groovy.parser.Parser

/**
 * Created by oleh on 01.12.15.
 */
class Main {

    public static void main(String[] args) {
//        Fruit lemon = new Lemon(12, Color.YELLOW, true, 12.36, Country.BRAZIL)
        List fruits = []
        fruits << new Lemon(12, Color.YELLOW, true, 12.36, Country.BRAZIL)
//        fruits << new Lemon(10, Color.YELLOW, false, 15.36, Country.ECUADOR)
        Generator generator = new Generator()
        String xml = generator.generate(fruits, true)
        println xml
        Parser parser = new Parser()
        parser.parse(xml, true)
    }

}
