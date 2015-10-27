package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 27.10.15.
 */
class Find {

    public static def findAllLaptops(List gadgets) {
        gadgets.findAll {
            it.find({key, value -> value == GadgetType.LAPTOP})
        }
    }

    public static def findAllRedBooks(List books) {
        books.findAll({
            it.find({
                key, value -> value == Colors.RED
            })
        })
    }

}
