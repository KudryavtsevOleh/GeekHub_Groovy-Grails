package com.oleh.groovy.generator

import com.oleh.groovy.fruits.Fruit
import groovy.json.JsonBuilder

/**
 * Created by oleh on 01.12.15.
 */
class Generator {

    public def generate(def fruits, Boolean isXml) {
        if (isXml) {
            generateXml(fruits)
        } else {
            Map properties = fruits.getProperties()
            generateJson(properties)
        }
    }

    private String generateXml(def fruits) {
        StringBuilder builder = new StringBuilder()
        generateFromList(fruits, builder)
        builder.toString()
    }

    private generateFromMap(StringBuilder builder, Fruit fruit) {
        Map fruitProperties = fruit.getProperties()
        builder.append('<fruit ')
                .append('name="')
                .append(fruit.getClass().getSimpleName().toLowerCase())
                .append('">')
        fruitProperties.each { key, value ->
            builder.append('<')
                    .append(key.toLowerCase())
                    .append('>')
                    .append(value)
                    .append('</')
                    .append(key.toLowerCase())
                    .append('>')
        }
        builder.append('</fruit>')
    }

    private generateFromList(def fruits, StringBuilder builder) {
        builder.append('<fruits>')
        fruits.each {
            generateFromMap(builder, it as Fruit)
        }
        builder.append('</fruits>')
    }

    private String generateJson(Map properties) {
        def builder = new JsonBuilder()
        builder.toString()
    }

}
