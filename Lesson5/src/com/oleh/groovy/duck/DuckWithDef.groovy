package com.oleh.groovy.duck

import groovy.transform.CompileStatic

/**
 * Created by Oleh Kudryavcev on 23.11.15.
 */
class DuckWithDef extends Duck {

    private def color
    private def breed
    private def weight
    private def height

    DuckWithDef(color, breed, weight, height) {
        this.color = color
        this.breed = breed
        this.weight = weight
        this.height = height
    }

    @Override
    @CompileStatic
    String quack() {
        StringBuilder builder = new StringBuilder();
        builder.append('Duck with def\n')
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
