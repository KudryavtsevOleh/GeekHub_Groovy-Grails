package com.geekhub

class UserController {

    UserService userService

    def index() {
        def user = userService.getUserByLogin(params.login)
        if (user) {
            render view: "dashboard", model: ["user": user]
        } else {
            redirect controller: "login", action: "index"
        }
    }

    def createBookPage() {
        render view: "book/addBook", model: ["user": user]
    }

    def allBooks() {
        def user = userService.getUserByLogin(params.login)
        if (user) {
            render view: "book/books", model: ["user": user, "books": Book.list()]
        } else {
            redirect controller: "login", action: "index"
        }
    }

    def saveBookInfo() {
        def user = userService.getUserByLogin(params.login)
        if (user) {
            params.user = user
            def book = new Book(params)
            if (book.validate()) {
                book.save()
                redirect action: allBooks(), params: ["login": user.login]
            } else {
                render view: "book/addBook", model: ["errorMessage": "Invalid input data"]
            }
        } else {
            redirect controller: "login", action: "index"
        }
    }

    def allMovies() {
        def user = userService.getUserByLogin(params.login)
        if (user) {
            render view: "movie/movies", model: ["user": user, "movies": Movie.list()]
        } else {
            redirect controller: "login", action: "index"
        }
    }

    def saveMovie() {
        def user = userService.getUserByLogin(params.login)
        if (user) {
            params.user = user
            def movie = new Movie(params)
            if (movie.validate()) {
                movie.save()
                redirect action: allMovies(), params: ["login": user.login]
            } else {
                render view: "movie/addMovie", model: ["errorMessage": "Invalid input data"]
            }
        } else {
            redirect controller: "login", action: "index"
        }
    }

    def allMusic() {
        def user = userService.getUserByLogin(params.login)
        if (user) {
            render view: "music/music", model: ["user": user, "music": Music.list()]
        } else {
            redirect controller: "login", action: "index"
        }
    }

    def saveMusic() {
        def user = userService.getUserByLogin(params.login)
        if (user) {
            params.user = user
            def music = new Music(params)
            if (music.validate()) {
                music.save()
                redirect action: allMusic(), params: ["login": user.login]
            } else {
                render view: "music/addMusic", model: ["errorMessage": "Invalid input data"]
            }
        } else {
            redirect controller: "login", action: "index"
        }
    }

}
