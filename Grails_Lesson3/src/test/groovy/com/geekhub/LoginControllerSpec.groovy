package com.geekhub

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginController)
@Mock([User, UserService])
class LoginControllerSpec extends Specification {

    void "success login"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            request.method = "POST"
            params.login = "oleha"
            params.password = "123456"

        when:
            controller.login()

        then:
            response.redirectedUrl == "/user/index"
    }

    void "failed login"() {
        given:
            request.method = "POST"
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()

        when:
            params.login = "#@@%"
            params.password = "123456"
            controller.login()

        then:
            view == "/login/index"
            model.success == false
            model.errorMessage == 'Invalid login or password'
    }

    void "success registration"() {
        given:
            request.method = "POST"
            params.login = "olehM"
            params.password = "123456"
            params.firstName = "oleh"
            params.lastName = "milicano"

        when:
            controller.register()

        then:
            response.redirectedUrl == "/user/index"
            User.findAllByLogin(params.login).size() == 1
    }

    void "failed registration (invalid request data)"() {
        given:
            request.method = "POST"
            params.login = "ole"
            params.password = "123456"
            params.firstName = "oleh"
            params.lastName = "milicano"

        when:
            controller.register()

        then:
            view == "/login/index"
            model.success == false
            model.errorMessage == "Invalid info"
    }

    void "failed registration (try to register user with already existing login)"() {
        given:
            request.method = "POST"
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.login = "oleha"
            params.password = "784512"
            params.firstName = "max"
            params.lastName = "kilick"

        when:
            controller.register()

        then:
            view == "/login/index"
            model.success == false
            model.errorMessage == "User with same login is already exist"
    }

}
