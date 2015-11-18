package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 16.11.15.
 */
class Main {

    private static final CONFIG_FILE_PATH = '/home/oleh/GeekHub_Groovy&Grails/GeekHub_Groovy-Grails/Lesson4/src/com/oleh/groovy/configuration.txt'

    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder()
        builder.build(10, CONFIG_FILE_PATH)
        List cars = builder.getCars()
        TestCar test = new TestCar()
        test.checkCars(cars)
        println "Serviceable cars count ${test.getServiceableCars()}"
        println "Faulty cars count ${test.getFaultyCars()}"
    }

}
