package com.geekhub

class Book {

    String title
    String author
    Integer pagesCount
    Integer priority

    static hasOne = [user: User]

    static constraints = {
        pagesCount min: 20, max: 1500
        priority min: 1, max: 5
    }
}
