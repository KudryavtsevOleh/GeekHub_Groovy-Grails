package com.oleh.groovy.parser

import com.oleh.groovy.enums.AppleType
import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.Country
import com.oleh.groovy.fruits.Apple
import com.oleh.groovy.fruits.Lemon
import groovy.util.slurpersupport.GPathResult
import groovy.xml.DOMBuilder
import groovy.xml.QName
import groovy.xml.StreamingMarkupBuilder

/**
 * Created by oleh on 01.12.15.
 */
class Parser {

    public void parse(String value, Boolean isXml) {
        if (isXml) {
            parseXmlUseXmlParser(value)
            parseXmlUseXmlSlurper(value)
        } else {

        }
    }

    private void parseXmlUseXmlParser(String xml) {
        println 'Parse Xml using XmlParser class.'
        def fruits = new XmlParser().parseText(xml)
        print fruits.fruit.weight.text() + ' '
        println fruits.fruit.color.text()
    }

    private void parseXmlUseXmlSlurper(String xml) {
        println 'Parse Xml using XmlSlurper class.'
        def slurper = new XmlSlurper()
        def fruits = slurper.parseText(xml)
        def apples = fruits.fruit.findAll {
            it.@name.toString().equals('apple')
        }
        apples.each {
            it.weight = 999.999
        }
        appendNode(fruits)
        createNode(slurper, fruits, "apple")
        createNode(slurper, fruits, "lemon")
        replaceNode(fruits)
        def records = workWithDOMCategory(xml)
        def fruit = fruits.value.fruits.fruit[0]
        println fruit
        println fruit.@name
        def newFruits = new StreamingMarkupBuilder().bind {
                    mkp.yield fruits
        }.toString()
        println newFruits
        println records
    }

    private def workWithDOMCategory(String xml) {
        def reader = new StringReader(xml)
        def doc = DOMBuilder.parse(reader)
        def records = doc.documentElement
        records
    }

    private replaceNode(GPathResult fruits) {
        fruits.value.fruits.fruit[0].replaceNode {
            fruit(name: "apple") {
                weiht("12.69")
                color("GREEN")
                issour("false")
            }
        }
    }

    private appendNode(def fruits) {
        fruits.appendNode {
            fruit(name: "apple") {
                weight 13.69
                color 'GREEN'
                issour false
                priceperkilo 19.34
                countryfrom 'USA'
            }
        }
    }

    private createNode(def xmlParser, def fruits, def fruitInstance) {
        xmlParser.createNode(
                fruits,
                "fruit",
                newInstanceProperties(fruitInstance as String)
        )
    }

    private Map newInstanceProperties(String instanceName) {
        if (instanceName.equals("apple")) {
            new Apple(1.3, Color.GREEN, 12, Country.CHINA, AppleType.ANTONOVKA).getProperties()
        } else {
            new Lemon(4.6, Color.YELLOW, true, 12.58, Country.UKRAINE).getProperties()
        }
    }

}
