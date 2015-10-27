package com.oleh.groovy.init

import com.oleh.groovy.enums.CarTypes
import com.oleh.groovy.enums.Colors
import com.oleh.groovy.enums.FoodTypes
import com.oleh.groovy.enums.GadgetTypes

/**
 * Created by Oleh Kudryavcev on 27.10.15.
 */
class Objects {

    private static def books = []
    private static def furniture = []
    private static def gadgets = []
    private static def cars = []
    private static def food = []

    public static void addBook(String title, Integer pagesCount, Double price, Colors color) {
        def book = [:]
        book.title = title
        book.pagesCount = pagesCount
        book.price = price
        book.color = color
        books << book
    }

    public static void addFurniture(String name, Integer height, Double weight, Double length) {
        def elementOfFurniture = [:]
        elementOfFurniture.name = name
        elementOfFurniture.height = height
        elementOfFurniture.weight = weight
        elementOfFurniture.length = length
        furniture << elementOfFurniture
    }

    public static void addGadget(GadgetTypes type, String model, Double price) {
        def gadget = [:]
        gadget.type = type
        gadget.model = model
        gadget.price = price
        gadgets << gadget
    }

    public static void addCar(CarTypes carType, Integer enginePower, Integer doorsCount) {
        def car = [:]
        car.carType = carType
        car.enginePower = enginePower
        car.doorsCount = doorsCount
        cars << car
    }

    public static void addFood(FoodTypes type,  Double weight) {
        def foodItem = [:]
        foodItem.type = type
        foodItem.weight = weight
        food << foodItem
    }

    static getBooks() {
        return books
    }
    static getFurniture() {
        return furniture
    }
    static getGadgets() {
        return gadgets
    }
    static getCars() {
        return cars
    }
    static getFood() {
        return food
    }
}
