package com.oleh.groovy.search

import com.oleh.groovy.enums.Colors
import com.oleh.groovy.enums.GadgetTypes

/**
 * Created by Oleh Kudryavcev on 27.10.15.
 */
class Find {

    public static def findAllLaptops(List gadgets) {
        gadgets.findAll {
            it.find({
                key, value -> value == GadgetTypes.LAPTOP
            })
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
