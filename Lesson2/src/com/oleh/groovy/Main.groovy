package com.oleh.groovy;

/**
 * Created by Oleh Kudryavcev on 24.10.15.
 */

class Main {

    static {
        ObjectsBuilder.buildBooksList()
        ObjectsBuilder.buildFurnitureList()
        ObjectsBuilder.buildGadgetsList()
    }

    static void main(String... args) {
        JsonBuilder jsonBuilder = new JsonBuilder()
        List gadgets = Objects.getGadgets()
        List furniture = Objects.getFurniture()
        List books = Objects.getBooks()
        String gadgetsJson = jsonBuilder.build(gadgets, "gadgets")
        String furnitureJson = jsonBuilder.build(furniture, "furniture")
        String booksJson = jsonBuilder.build(books, "books")
        println gadgetsJson
        println furnitureJson
        println booksJson
        println Find.findAllLaptops(gadgets)
        println Find.findAllRedBooks(books)
    }

}