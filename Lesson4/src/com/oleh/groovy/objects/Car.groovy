package com.oleh.groovy.objects

import com.oleh.groovy.enums.Color

/**
 * Created by Oleh Kudryavcev on 16.11.15.
 */
class Car {

    private Boolean frame
    private Engine engine
    private Color color
    private Boolean leftFrontWheel
    private Boolean rightFrontWheel
    private Boolean leftBackWheel
    private Boolean rightBackWheel
    private Boolean doors
    private Boolean seats

    Boolean getFrame() {
        return frame
    }
    void setFrame(Boolean frame) {
        this.frame = frame
    }

    Engine getEngine() {
        return engine
    }
    void setEngine(Engine engine) {
        this.engine = engine
    }

    Color getColor() {
        return color
    }
    void setColor(Color color) {
        this.color = color
    }

    Boolean getLeftFrontWheel() {
        return leftFrontWheel
    }
    void setLeftFrontWheel(Boolean leftFrontWheel) {
        this.leftFrontWheel = leftFrontWheel
    }

    Boolean getRightFrontWheel() {
        return rightFrontWheel
    }
    void setRightFrontWheel(Boolean rightFrontWheel) {
        this.rightFrontWheel = rightFrontWheel
    }

    Boolean getLeftBackWheel() {
        return leftBackWheel
    }
    void setLeftBackWheel(Boolean leftBackWheel) {
        this.leftBackWheel = leftBackWheel
    }

    Boolean getRightBackWheel() {
        return rightBackWheel
    }
    void setRightBackWheel(Boolean rightBackWheel) {
        this.rightBackWheel = rightBackWheel
    }

    Boolean getDoors() {
        return doors
    }
    void setDoors(Boolean doors) {
        this.doors = doors
    }

    Boolean getSeats() {
        return seats
    }
    void setSeats(Boolean seats) {
        this.seats = seats
    }
}