package com.test.insourcetake2.presenter

import android.util.Log
import com.test.insourcetake2.apiUtils.ApiUtils
import com.test.insourcetake2.contracts.BasePresenter
import com.test.insourcetake2.contracts.RegisterPresenterInterface
import com.test.insourcetake2.model.AuthToken
import com.test.insourcetake2.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter : BasePresenter<RegisterPresenterInterface.View>(), RegisterPresenterInterface.Presenter {

    override fun verifyData(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerRequest(user: User) {
        val networkCall = ApiUtils()
        networkCall.getServiceClass()?.register(
            user.firstname!!, user.lastname!!, user.email!!,
            user.password!!, user.passwordConfirm!!, user.phonenumber!!,
            user.employeenumber!!, user.position!!, user.companyname!!,
            user.linkedin!!
        )?.enqueue(object : Callback<AuthToken> {
            override fun onFailure(call: Call<AuthToken>, t: Throwable) {
                getView()?.showSucessfullToast("Register Failed : Network Error")
                Log.e("Register Fail", t.cause.toString())
            }

            override fun onResponse(call: Call<AuthToken>, response: Response<AuthToken>) {
                if (response.isSuccessful) {
                    getView()?.showSucessfullToast(response.message())
                    getView()?.startLoginActivity()

                } else {
                    getView()?.showUnsucessfulToast(response.message())
                    Log.e("Register Fail", response.message())
                }
            }
        })
    }
}