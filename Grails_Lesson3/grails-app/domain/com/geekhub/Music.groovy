package com.geekhub

class Music {

    String name
    String group
    Double duration
    Integer priority
    User user

    static hasOne = [user: User]

    static constraints = {
        priority min: 1, max: 5
    }
}
