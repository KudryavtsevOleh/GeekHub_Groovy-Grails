package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 27.10.15.
 */
class ObjectsBuilder {

    static void buildBooksList() {
        Objects.addNewBook("First Book", 120, 12.50, Colors.BLACK)
        Objects.addNewBook("Second Book", 220, 12.60, Colors.YELLOW)
        Objects.addNewBook("Third Book", 320, 12.90, Colors.RED)
    }

    static void buildFurnitureList() {
        Objects.addNewFurniture("First furniture", 12, 12, 12)
        Objects.addNewFurniture("Second furniture", 11, 11, 11)
        Objects.addNewFurniture("Third furniture", 10, 10, 10)
    }

    static void buildGadgetsList() {
        Objects.addGadget(GadgetType.LAPTOP, "AC1256", 1245.25)
        Objects.addGadget(GadgetType.LAPTOP, "MPQ1278", 2458.25)
        Objects.addGadget(GadgetType.SMARTPHONE, "6s", 1200.00)
        Objects.addGadget(GadgetType.TABLET_PC, "ZM1245", 148.70)
        Objects.addGadget(GadgetType.PC, "CMP4578", 4148.70)
        Objects.addGadget(GadgetType.MUSIC_PLAYER, "Nano", 685.78)
        Objects.addGadget(GadgetType.TV, "55UHD", 12458.25)
    }

}
