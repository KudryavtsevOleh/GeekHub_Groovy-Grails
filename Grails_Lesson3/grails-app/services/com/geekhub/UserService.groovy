package com.geekhub

import grails.transaction.Transactional

@Transactional
class UserService {

    def getUserByLoginAndPassword(String login, String password) {
        User.findByLoginAndPassword(login, password)
    }

    def getUserByLogin(String login) {
        User.findAllByLogin(login)
    }

    def getSortedBooksByUserId(Integer id) throws UserException {
        def user = User.get(id)
        Asserts.assertUser(user)
        Book.findAllByUser(user, [order: "desc"])
    }

    def getSortedMoviesByUserId(Integer id) throws UserException {
        def user = User.get(id)
        Asserts.assertUser(user)
        Movie.findAllByUser(user)
    }

    def getSortedMusicByUserId(Integer id) throws UserException {
        def user = User.get(id)
        Asserts.assertUser(user)
        Music.findAllByUser(user)
    }

    def getBooksWithHeightRating() {
        def criteria = Book.createCriteria()
        criteria.list {
            or {
                gt("priority", 3)
            }
        }

    }

}