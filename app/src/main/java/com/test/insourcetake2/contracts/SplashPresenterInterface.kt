package com.test.insourcetake2.contracts

interface SplashPresenterInterface {

    interface Presenter {
        //check if this is the first run and the user didn't Login in the first place
        fun userCheck()

        //check for TokenValidation
        fun validateToken()

        //Re-Login if necessary
        fun reLogin(email: String, password: String)

    }

    interface View {
        fun getToken() : String?
    }


}