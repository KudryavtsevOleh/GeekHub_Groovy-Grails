package com.oleh.groovy.parser

import com.oleh.groovy.enums.Color
import com.sun.scenario.effect.impl.sw.java.JSWBlend_GREENPeer

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

    private void parseXmlUseXmlSlurper(String value) {
        println 'Parse Xml using XmlSlurper class.'
        def fruits = new XmlSlurper().parseText(value)
        def apples = fruits.fruit.findAll {
            it.@name.toString().equals('apple')
        }
        apples.each {
            it.weight = 999.999
        }
        fruits.appendNode {
            fruit(name: "pear") {
                weight 13.69
                color 'GREEN'
                issour false
                priceperkilo 19.34
                countryfrom 'USA'
            }
        }
    }

}
