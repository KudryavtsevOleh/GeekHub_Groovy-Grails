package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 27.10.15.
 */
class Objects {

    private static def books = []
    private static def furniture = []
    private static def gadgets = []

    public static void addNewBook(String title, Integer pagesCount, Double price, Colors color) {
        def book = [:]
        book.title = title
        book.pagesCount = pagesCount
        book.price = price
        book.color = color
        books << book
    }

    public static void addNewFurniture(String name, Integer height, Double weight, Double length) {
        def elementOfFurniture = [:]
        elementOfFurniture.name = name
        elementOfFurniture.height = height
        elementOfFurniture.weight = weight
        elementOfFurniture.length = length
        furniture << elementOfFurniture
    }

    public static void addGadget(GadgetType type, String model, Double price) {
        def gadget = [:]
        gadget.type = type
        gadget.model = model
        gadget.price = price
        gadgets << gadget
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
}
