package com.oleh.groovy.builder

import com.oleh.groovy.init.Objects
import com.oleh.groovy.enums.CarTypes
import com.oleh.groovy.enums.Colors
import com.oleh.groovy.enums.FoodTypes
import com.oleh.groovy.enums.GadgetTypes

/**
 * Created by Oleh Kudryavcev on 27.10.15.
 */
class ObjectsBuilder {

    static void buildBooksList() {
        Objects.addBook("First Book", 120, 12.50, Colors.BLACK)
        Objects.addBook("Second Book", 220, 12.60, Colors.YELLOW)
        Objects.addBook("Third Book", 320, 12.90, Colors.RED)
    }

    static void buildFurnitureList() {
        Objects.addFurniture("First furniture", 12, 12, 12)
        Objects.addFurniture("Second furniture", 11, 11, 11)
        Objects.addFurniture("Third furniture", 10, 10, 10)
    }

    static void buildGadgetsList() {
        Objects.addGadget(GadgetTypes.LAPTOP, "AC1256", 1245.25)
        Objects.addGadget(GadgetTypes.LAPTOP, "MPQ1278", 2458.25)
        Objects.addGadget(GadgetTypes.SMARTPHONE, "6s", 1200.00)
        Objects.addGadget(GadgetTypes.TABLET_PC, "ZM1245", 148.70)
        Objects.addGadget(GadgetTypes.PC, "CMP4578", 4148.70)
        Objects.addGadget(GadgetTypes.MUSIC_PLAYER, "Nano", 685.78)
        Objects.addGadget(GadgetTypes.TV, "55UHD", 12458.25)
    }

    static void buildCarList() {
        Objects.addCar(CarTypes.COUPE, 125, 5)
        Objects.addCar(CarTypes.HATCHBACK, 150, 4)
        Objects.addCar(CarTypes.SEDAN, 110, 4)
        Objects.addCar(CarTypes.SUV, 200, 5)
    }

    static void buildFoodList() {
        Objects.addFood(FoodTypes.FRUIT, 250)
        Objects.addFood(FoodTypes.VEGETABLE, 100)
        Objects.addFood(FoodTypes.MEAT, 1000)
    }

}
