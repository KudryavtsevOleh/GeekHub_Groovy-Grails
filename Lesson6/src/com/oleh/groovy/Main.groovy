package com.oleh.groovy

import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.Country
import com.oleh.groovy.fruits.Fruit
import com.oleh.groovy.fruits.Lemon
import com.oleh.groovy.generator.GeneratorXml
import com.oleh.groovy.parsers.ParserJson
import com.oleh.groovy.parsers.ParserXml
import com.oleh.groovy.parsers.TemplateEngines

/**
 * Created by oleh on 01.12.15.
 */
class Main {

    private static List<Fruit> fruits = [
            new Lemon(12, Color.YELLOW, true, 12.36, Country.BRAZIL),
            new Lemon(10, Color.YELLOW, false, 15.36, Country.ECUADOR)
    ]

    public static void main(String[] args) {
        GeneratorXml generator = new GeneratorXml()
        def xml = generator.generate(fruits)
        ParserXml parserXml = new ParserXml()
        parserXml.parse(xml)
        ParserJson parserJson = new ParserJson()
        parserJson.parse()
        TemplateEngines.use()
    }

}
