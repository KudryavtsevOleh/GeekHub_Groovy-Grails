package com.geekhub

/**
 * Created by oleh on 19.01.16.
 */
class Asserts {

    static void assertUser(User user) throws UserException {
        if (!user) throw new UserException("No such user.")
    }

}
