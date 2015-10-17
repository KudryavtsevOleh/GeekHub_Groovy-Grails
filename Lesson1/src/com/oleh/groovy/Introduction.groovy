package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 17.10.15.
 */
class Introduction {

    boolean shortVersion

    Introduction(boolean shortVersion) {
        this.shortVersion = shortVersion
    }

    void introduce(Person person) {
        if (shortVersion) {
            shortIntroduction(person)
        } else {
            fullIntroduction(person)
        }
    }

    private static def shortIntroduction(Person person) {
        print """
                    Hello, my name is ${person.name}.
                    I am ${person.yearsOld} years old.
                    I am ${person.activity}.
               """
    }

    private static def fullIntroduction(Person person) {
        print """
                    Hello, my name is ${person.name}.
                    I am ${person.yearsOld} years old.
                    I am ${person.activity}.
                    I like ${person.hobbies}.
               """
    }

}
