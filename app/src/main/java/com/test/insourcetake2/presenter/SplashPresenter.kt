package com.test.insourcetake2.presenter

import com.test.insourcetake2.contracts.BasePresenter
import com.test.insourcetake2.contracts.SplashPresenterInterface

class SplashPresenter : BasePresenter<SplashPresenterInterface.View>(), SplashPresenterInterface.Presenter{

    override fun userCheck() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validateToken() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reLogin(email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}