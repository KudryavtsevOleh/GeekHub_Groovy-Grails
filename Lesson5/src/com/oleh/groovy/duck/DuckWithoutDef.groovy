package com.oleh.groovy.duck

import com.oleh.groovy.enums.Color
import com.oleh.groovy.enums.DuckBreed

/**
 * Created by Oleh Kudryavcev on 23.11.15.
 */
class DuckWithoutDef extends Duck {

    private Color color
    private DuckBreed breed
    private Double weight
    private Double height

    DuckWithoutDef(Color color, DuckBreed breed, Double weight, Double height) {
        this.color = color
        this.breed = breed
        this.weight = weight
        this.height = height
    }

    @Override
    String quack() {
        StringBuilder builder = new StringBuilder();
        builder.append('Duck without def\n')
                .append('Color ')
                .append(this.color)
                .append('\n')
                .append("Duck breed ")
                .append(this.breed)
                .append('\n')
                .append('Duck weight ')
                .append(this.weight)
                .append('\n')
                .append('Duck height ')
                .append(this.height)
                .append('\n')
        return builder.toString()
    }

    @Override
    public String toString() {
        return quack()
    }
}
