package com.oleh.groovy

/**
 * Created by Oleh Kudryavcev on 17.10.15.
 */
class Person {

    int yearsOld
    String name
    List<String> hobbies
    String activity

    Person(int yearsOld, String name, String activity) {
        this.yearsOld = yearsOld
        this.name = name
        this.activity = activity
        this.hobbies = new ArrayList<>();
    }

    void setHobby(String hobby) {
        this.hobbies << hobby
    }

}
