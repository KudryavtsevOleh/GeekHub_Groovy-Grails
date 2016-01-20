package com.geekhub

class User {

    String login
    String password
    String firstName
    String lastName

    static hasMany = [
            books: Book,
            movies: Movie,
            music: Music
    ]

    static constraints = {
        login size: 4..10, nullable:false, unique: true
        password size: 5..15, nullable: false
    }
}
