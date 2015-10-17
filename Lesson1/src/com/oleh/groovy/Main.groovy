package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 17.10.15.
 */
class Main {

    static void main(String... args) {
        Person person = new Person(20, 'Oleh', 'student')
        person.setHobby('programming')
        person.setHobby('sport')

        Introduction intro = new Introduction(false)
        intro.introduce(person)

        intro.setShortVersion(true)
        intro.introduce(person)

        involutionTest()
    }

    private static involutionTest() {
        int number = 76
        int grade = 44
        assert number ** grade == Math.pow(76, 44)
    }

}
