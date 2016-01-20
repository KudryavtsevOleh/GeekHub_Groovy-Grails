package com.geekhub

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([Book, User, UserService])
class UserControllerSpec extends Specification {


    void "test index action success"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.login = "oleha"

        when:
            controller.index()

        then:
            view == "/user/dashboard"
    }

    void "test index action failed"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.login = "olehb"

        when:
            controller.index()

        then:
            response.redirectedUrl == "/login/index"
    }

    void "test index action (success | correct request login)"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.login = "oleha"

        when:
            controller.index()

        then:
            view == "/user/dashboard"
    }

    void "test index action (failed | invalid request login)"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.login = "olehb"

        when:
            controller.index()

        then:
            response.redirectedUrl == "/login/index"
    }

    void "success save book"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.name = "Olivier Twist"
            params.author = "Charles Dickens"
            params.pagesCount = 215
            params.priority = 4
            params.login = "oleha"

        when:
            controller.saveBookInfo()

        then:
            view == "/user/book/addBook"

    }

    void "failed save book (invalid request data)"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.name = "Olivier Twist"
            params.author = "Charles Dickens"
            params.pagesCount = 10
            params.priority = 4
            params.login = "oleha"

        when:
            controller.saveBookInfo()

        then:
            view == "/user/book/addBook"
            model.errorMessage == "Invalid input data"
    }

    void "failed save book (empty user)"() {
        given:
            def user = new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev").save()
            params.name = "Olivier Twist"
            params.author = "Charles Dickens"
            params.pagesCount = 215
            params.priority = 4
            params.login = "olehb"

        when:
            controller.saveBookInfo()

        then:
            response.redirectedUrl == "/login/index"
    }

    void "save music success"() {

    }

    void "save music failed"() {

    }

    void "save movie success"() {

    }

    void "save movie failed"() {

    }

}
