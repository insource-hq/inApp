package com.test.insourcetake2.contracts

import android.content.Context

interface LoginPresenterInterface {

    interface Presenter {
        //login verify
        fun isValidEmail(email: String?): Boolean

        fun isValidPassword(password: String):Boolean

        //request
        fun requestLogin(email: String, password: String) : Boolean?

    }

    interface View {

        fun showSucessfullLoginToast(message:String)
        fun showUnsucessfulLoginToast(message:String)
        fun startMainActivity()
        fun storeToken(token: String?)

    }


}