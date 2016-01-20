package com.geekhub

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
@Mock([User, Book, Music, Movie])
class UserServiceSpec extends Specification {

    final DEFAULT_USER_ID = 1
    final ERROR_USER_ID = 2

    private def defaultUser() {
        new User(login: "oleha", password: "123456", firstName: "oleh", lastName: "kudryavcev")
    }

    private def createBooksList(def user) {
        def books = []
        books.add(new Book(title: "Book 1", author: "Author 1", pagesCount: 569, priority: 3, user: user))
        books.add(new Book(title: "Book 2", author: "Author 2", pagesCount: 569, priority: 5, user: user))
        books.add(new Book(title: "Book 3", author: "Author 3", pagesCount: 569, priority: 4, user: user))
        books.add(new Book(title: "Book 4", author: "Author 4", pagesCount: 569, priority: 5, user: user))
        books.add(new Book(title: "Book 5", author: "Author 5", pagesCount: 569, priority: 1, user: user))
        books
    }

    void "get sorted list of added books"() {
        given:
            def user = defaultUser().save()
            for (def book in createBooksList(user)) {
                book.save()
            }

        when:
            def books = service.getSortedBooksByUserId(DEFAULT_USER_ID)

        then:
            books.size() == 5
    }

    void "check wrong user id"() {
        when:
            def books = service.getSortedBooksByUserId(ERROR_USER_ID)
            def movies = service.getSortedMoviesByUserId(ERROR_USER_ID)
            def music = service.getSortedMusicByUserId(ERROR_USER_ID)

        then:
            books == null
            movies == null
            music == null
            thrown(UserException)

    }

    private def createMoviesList(def user) {
        def movies = []
        movies.add(new Movie(name: "Movie 1", duration: 1.25, priority: 3, user: user))
        movies.add(new Movie(name: "Movie 2", duration: 1.25, priority: 4, user: user))
        movies.add(new Movie(name: "Movie 3", duration: 1.25, priority: 5, user: user))
        movies.add(new Movie(name: "Movie 4", duration: 2.25, priority: 1, user: user))
        movies.add(new Movie(name: "Movie 5", duration: 2.25, priority: 1, user: user))
        movies.add(new Movie(name: "Movie 6", duration: 2.25, priority: 2, user: user))
        movies
    }

    void "get sorted list of added movies"() {
        given:
            def user = defaultUser().save()
            for (def movie in createMoviesList(user)) {
                movie.save()
            }

        when:
            def movies = service.getSortedMoviesByUserId(DEFAULT_USER_ID)

        then:
            movies.size() == 6
    }

    private def createMusicList(def user) {
        def music = []
        music.add(new Music(name: "Song 1", group: "Group 1", duration: 5.25, priority: 5, user: user))
        music.add(new Music(name: "Song 2", group: "Group 2", duration: 5.25, priority: 3, user: user))
        music.add(new Music(name: "Song 3", group: "Group 3", duration: 5.25, priority: 1, user: user))
        music.add(new Music(name: "Song 4", group: "Group 4", duration: 5.25, priority: 4, user: user))
        music
    }

    void "get sorted list of added music"() {
        given:
            def user = defaultUser().save()
            for (def music in createMusicList(user)) {
                music.save()
            }

        when:
            def music = service.getSortedMusicByUserId(DEFAULT_USER_ID)

        then:
            music.size() == 4
    }

    void "get users by same login"() {
        given:
            def user1 = defaultUser().save()
            def user2 = defaultUser().save()

        when:
            def users = service.getUserByLogin(user1.login)

        then:
            users.size == 2
    }

    void "get books with height rating"() {
        given:
            def user = defaultUser().save()
            for (def book in createBooksList(user)) {
                book.save()
            }

        when:
            def highestRating = service.getBooksWithHeightRating()

        then:
            highestRating.size() == 3
    }

}
