package com.test.insourcetake2.apiUtils

class ApiUtils : ApiPresenter() {
    private val BASE_URL = "https://protected-inlet-29390.herokuapp.com/api/user/"


    fun getServiceClass(): RetrofitInterface? {
        return getRetrofit(BASE_URL)?.create(RetrofitInterface::class.java)
    }
}