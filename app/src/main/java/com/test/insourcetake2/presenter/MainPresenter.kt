package com.test.insourcetake2.presenter

import android.util.Log
import com.test.insourcetake2.model.Data
import com.test.insourcetake2.model.Order
import com.test.insourcetake2.apiUtils.ApiUtils
import com.test.insourcetake2.contracts.BasePresenter
import com.test.insourcetake2.contracts.MainPresenterInterface
import com.test.insourcetake2.model.OrderDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : MainPresenterInterface.Presenter, BasePresenter<MainPresenterInterface.View>() {
    val networkCall: ApiUtils = ApiUtils()

    override fun getOrders(): List<Data> {

        lateinit var list: List<Data>
        networkCall.getServiceClass()?.orders?.enqueue(object : Callback<Order> {
            override fun onFailure(call: Call<Order>, t: Throwable) {
                getView()?.showUnsucessfulToast("Network Error")
                Log.e("Add Order Error", t.message.toString())
            }

            override fun onResponse(call: Call<Order>, response: Response<Order>) {
                if (response.isSuccessful) {
                    getView()?.showSucessfullToast(response.message())
                    list = response.body()?.getData()!!
                } else {
                    getView()?.showUnsucessfulToast(response.message())
                }
            }

        })
        return list
    }

    override fun addOrder(details: OrderDetails) {
        networkCall.getServiceClass()?.addOrder(
            details.getTitle(), details.getDescription(),
            details.getCategoryId(), details.getFreeTime()
        )?.enqueue(object : Callback<Order> {
            override fun onFailure(call: Call<Order>, t: Throwable) {
                getView()?.showUnsucessfulToast("Network Error")
                Log.e("Add Order Error", t.message.toString())
            }

            override fun onResponse(call: Call<Order>, response: Response<Order>) {

                if (response.isSuccessful) {
                    getView()?.showSucessfullToast(response.message())
                } else {
                    getView()?.showUnsucessfulToast(response.message())
                }

            }
        })
    }

}