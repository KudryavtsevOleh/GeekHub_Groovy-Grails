package com.oleh.groovy.builder

import com.oleh.groovy.enums.Color
import com.oleh.groovy.objects.Car
import com.oleh.groovy.objects.Engine

/**
 * Created by Oleh Kudryavcev on 16.11.15.
 */
class CarBuilder {

    private List<Car> cars = []

    public void build(Integer carsCount, String configPath) {
        Integer counter = 1
        File config = new File(configPath)
        while (counter <= carsCount) {
            Car car = new Car()
            println "///////---------- Car ${counter} on build ----------///////"
            config.eachLine {process(car, it)}
            cars << car
            counter++
        }
    }

    private void process(Car car, String action) {
        if (action.equals('FRAME')) createFrame.call(car)
        if (action.equals('ENGINE')) addEngine.call(car)
        if (action.equals('DOORS')) addDoors.call(car)
        if (action.equals('WHEELS')) addWheels.call(car)
        if (action.equals('SEATS')) addSeats.call(car)
        if (action.equals('COLOR')) carPainting.call(car)
    }

    private def createFrame = { Car car ->
        println '----- Creating frame -----'
        car.setFrame(true)
        println '----- Frame was created -----'
    }

    private def addEngine = { Car car ->
        Integer power = Math.random() * 100 + 50
        Double fuel = Math.random() * 50 + 50
        Integer checkedValue = Math.random() * 5 + 1
        car.setEngine(new Engine(power, fuel, checkedValue))
        println "----- Engine is here. Power - ${power} and fuel capacity - ${fuel} -----"
    }

    private def addDoors = { Car car ->
        println '----- Add first door -----'
        println '----- Add second door -----'
        println '----- Add third door -----'
        println '----- Add forth door -----'
        car.setDoors(true)
    }

    private def addWheels = { Car car ->
        println '----- Add left front wheel -----'
        car.setLeftFrontWheel(true)
        println '----- Add right front wheel -----'
        car.setRightFrontWheel(true)
        println '----- Add left back wheel -----'
        car.setLeftBackWheel(true)
        println '----- Add right back wheel -----'
        car.setRightBackWheel(true)
    }

    private def addSeats = { Car car ->
        println '----- Add seats -----'
        car.setSeats(true)
    }

    private def carPainting = { Car car ->
        println '----- Paint car -----'
        Integer color = Math.random() * 5 + 1
        car.setColor(Color.getByOrdinal(color))
    }

    List<Car> getCars() {
        return cars
    }
}
