package com.geekhub

class Movie {

    String name
    Double duration
    Integer priority
    User user

    static hasOne = [user: User]

    static constraints = {
        priority min: 1, max: 5
    }
}
