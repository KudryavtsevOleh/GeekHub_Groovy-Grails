package com.oleh.groovy.builder.json

/**
 * Created by Oleh Kudryavcev on 26.10.15.
 */
class JsonBuilder {

    public String build(List buildFrom, String jsonName) {
        StringBuilder builder = new StringBuilder();
        int commaCounter = 0
        builder
                .append('{ ')
                .append('"')
                .append(jsonName)
                .append('"')
                .append(" : {")
        buildFrom.each {
            commaCounter++
            if (it instanceof Map) {
                String buildResult = buildFromMap(it, commaCounter < buildFrom.size())
                builder.append(buildResult)
            } else {
                builder
                        .append('"')
                        .append(it)
                        .append('":')
                        .append('"')
                        .append(it)
                        .append('"')
                        .append(commaCounter < buildFrom.size() ? ',' : '')
            }
        }
        builder
                .append("}")
                .append("}")
        return builder.toString()
    }

    private String buildFromMap(Map buildFrom, Boolean isNeedComma) {
        StringBuilder builder = new StringBuilder()
        int commaCounter = 0
        builder
                .append('"')
                .append("type")
                .append('":')
                .append("{")
                .append()
        buildFrom.each { key, value ->
            commaCounter++
            builder
                    .append('"')
                    .append(key)
                    .append('"')
                    .append(":")
                    .append('"')
                    .append(value)
                    .append('"')
                    .append(commaCounter < buildFrom.size() ? "," : '')
        }
        builder
                .append(" }")
                .append(isNeedComma ? ',' : '')
        return builder.toString()
    }

}
