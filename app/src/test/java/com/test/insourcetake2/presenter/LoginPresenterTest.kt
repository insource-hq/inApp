package com.test.insourcetake2.presenter

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginPresenterTest {

    val presenter = LoginPresenter()
    val rightEmail = "my.mepharo1230@gmail.com"
    val wrongEmail = "my.mepharo1230@gmail"
    val wrongPassword = "password"
    val rightPassword = "thisisagoodpassword"


    @Test
    fun testValidEmail() {
//        assert(presenter.isValidEmail(rightEmail))
        assert(presenter.isValidEmail("google"))
    }

    @Test
    fun testValidPassword() {

        assertTrue(presenter.isValidPassword(rightPassword))
        assertFalse(presenter.isValidPassword(wrongPassword))

    }



}