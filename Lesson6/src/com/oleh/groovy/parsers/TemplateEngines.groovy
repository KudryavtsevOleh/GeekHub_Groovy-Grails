package com.oleh.groovy.parsers

import groovy.text.SimpleTemplateEngine
import groovy.text.StreamingTemplateEngine

/**
 * Created by oleh on 03.12.15.
 */
class TemplateEngines {

    public static use() {
        simpleTemplateEngine()
        streamingTemplateEngine()
    }

    private static simpleTemplateEngine() {
        println 'USING OF SIMPLE TEMPLATE ENGINE'
        def text = 'Dear "$firstName $lastName",\nPlease come to "$location" to get your prize'
        def binding = [
                "firstName": "Sam",
                "lastName": "Binding",
                "location": "Crouch End"
        ]
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(text).make(binding)
        println template.toString()
    }

    private static streamingTemplateEngine() {
        println 'USING OF STREAMING TEMPLATE ENGINE'
        def text = 'Dear <%out.print firstName%> ${lastName},\nPlease come to "$location" in ${time} to get your prize'
        def binding = [
                firstName: 'Alex',
                lastName: 'Mirock',
                location: 'Mita Center',
                time: new Date().getTime()
        ]
        def template = new StreamingTemplateEngine().createTemplate(text).make(binding)
        println template.toString()
    }

}
