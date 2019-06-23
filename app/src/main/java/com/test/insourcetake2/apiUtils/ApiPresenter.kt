package com.test.insourcetake2.apiUtils

import com.google.gson.GsonBuilder
import com.test.insourcetake2.contracts.BasePresenter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class ApiPresenter : NetworkInterface.NetworkPresenter, BasePresenter<NetworkInterface.NetworkView>() {

    override fun getRetrofit(BaseUrl: String): Retrofit? {

        val client = getClient(getView()?.getToken())

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    override fun getClient(T: String?): OkHttpClient {

        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder().header("Authorization", "Bearer $T").build()
            chain.proceed(request)
        }.build()

    }

}