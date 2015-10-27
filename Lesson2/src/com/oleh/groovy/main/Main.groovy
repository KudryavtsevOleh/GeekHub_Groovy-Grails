package com.oleh.groovy.main

import com.oleh.groovy.init.Objects
import com.oleh.groovy.builder.json.JsonBuilder
import com.oleh.groovy.builder.ObjectsBuilder
import com.oleh.groovy.search.Find;

/**
 * Created by Oleh Kudryavcev on 24.10.15.
 */

class Main {

    static {
        ObjectsBuilder.buildBooksList()
        ObjectsBuilder.buildFurnitureList()
        ObjectsBuilder.buildGadgetsList()
        ObjectsBuilder.buildCarList()
        ObjectsBuilder.buildFoodList()
    }

    static void main(String... args) {
        JsonBuilder jsonBuilder = new JsonBuilder()
        List gadgets = Objects.getGadgets()
        List furniture = Objects.getFurniture()
        List books = Objects.getBooks()
        List cars = Objects.getCars()
        List food = Objects.getFood()
        String gadgetsJson = jsonBuilder.build(gadgets, "gadgets")
        String furnitureJson = jsonBuilder.build(furniture, "furniture")
        String booksJson = jsonBuilder.build(books, "books")
        String carJson = jsonBuilder.build(cars, "cars")
        String foodJson = jsonBuilder.build(food, "food")
        println gadgetsJson
        println furnitureJson
        println booksJson
        println carJson
        println foodJson
        println Find.findAllLaptops(gadgets)
        println Find.findAllRedBooks(books)
    }

}