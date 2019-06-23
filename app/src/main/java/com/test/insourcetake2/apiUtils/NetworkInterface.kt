package com.test.insourcetake2.apiUtils

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface NetworkInterface {

    interface NetworkPresenter {
        fun getRetrofit(BaseUrl:String): Retrofit?
        fun getClient(T: String?): OkHttpClient
    }

    interface NetworkView {
        fun getToken(): String?
    }
}
