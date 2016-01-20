package com.geekhub

class LoginController {

    UserService userService

    def index() { render view: "index" }

    def login() {
        def user = userService.getUserByLoginAndPassword(params.login, params.password)
        if (user) {
            redirect controller: "user", action: "index", params: ["login", user.login]
        } else {
            render view: "index", model: ["success": false, "errorMessage": "Invalid login or password"]
        }
    }

    def register() {
        def user = new User(params)
        if (user.validate()) {
            def userWithSameLogin = userService.getUserByLogin(params.login)
            if (userWithSameLogin) {
                render view: "index", model: ["success": false, "errorMessage": "User with same login is already exist"]
            } else {
                user.save()
                redirect controller: "user", action: "index", params: ["login", user.login]
            }
        } else {
            render view: "index", model: ["success": false, "errorMessage": "Invalid info"]
        }
    }

}