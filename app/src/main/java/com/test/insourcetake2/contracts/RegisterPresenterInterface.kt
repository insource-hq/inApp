package com.test.insourcetake2.contracts

import com.test.insourcetake2.model.User

interface RegisterPresenterInterface {

    interface Presenter {
        //DataVerification
        fun verifyData(user: User)

        //Request
        fun registerRequest(user: User)
    }

    interface View {
        fun showProgressbar()
        fun hideProgressBar()

        fun showSucessfullToast(message: String)
        fun showUnsucessfulToast(message: String)
        fun startLoginActivity()
    }


}