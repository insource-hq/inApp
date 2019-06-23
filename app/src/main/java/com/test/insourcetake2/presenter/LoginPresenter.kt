package com.test.insourcetake2.presenter

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import com.test.insourcetake2.model.AuthToken
import com.test.insourcetake2.apiUtils.ApiUtils
import com.test.insourcetake2.contracts.BasePresenter
import com.test.insourcetake2.contracts.LoginPresenterInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter : LoginPresenterInterface.Presenter, BasePresenter<LoginPresenterInterface.View>() {


    override fun isValidEmail(email: String?): Boolean {
        return email?.isNotBlank()!! && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun isValidPassword(password: String): Boolean = password.isNotEmpty() &&
            password.length >= 8

    override fun requestLogin(email: String, password: String): Boolean? {

        var bool: Boolean? = false

        val networkCall = ApiUtils()


        networkCall.getServiceClass()?.getToken(email, password)?.enqueue(object : Callback<AuthToken> {
            override fun onFailure(call: Call<AuthToken>, t: Throwable) {
                getView()?.showUnsucessfulLoginToast("Login Failed : Network Error")
                Log.e("Login Fail", t.cause.toString())
            }

            override fun onResponse(call: Call<AuthToken>, response: Response<AuthToken>) {

                if (response.isSuccessful) {
                    getView()?.showSucessfullLoginToast(response.message())
                    getView()?.storeToken(response.body()?.getToken())
                    getView()?.startMainActivity()
                    bool = response.body()?.getStatus()

                } else {
                    getView()?.showUnsucessfulLoginToast(response.message())
                    Log.e("Login Fail", response.message())
                }

            }

        })


        return bool

    }


}