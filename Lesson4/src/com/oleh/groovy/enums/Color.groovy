package com.oleh.groovy.enums

/**
 * Created by oleh on 16.11.15.
 */
enum Color {
    RED,
    GREEN,
    BLUE,
    BLACK,
    WHITE

    public static Color getByOrdinal(Integer ordinal) {
        if (ordinal == RED.ordinal()) return RED
        if (ordinal == GREEN.ordinal()) return GREEN
        if (ordinal == BLUE.ordinal()) return BLUE
        if (ordinal == BLACK.ordinal()) return BLACK
        if (ordinal == WHITE.ordinal()) return WHITE
    }

}