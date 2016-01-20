package com.geekhub

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
@Mock(Book)
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "test saving to db"() {
        given:
            def book = new Book(title: "Salems Lot", author: "Stiphen King", pagesCount: 569, priority: 5)

        when:
            book.save()

        then:
            Book.count == 1
    }
}
