package com.test.insourcetake2.presenter

import android.util.Log
import com.test.insourcetake2.model.Order
import com.test.insourcetake2.apiUtils.ApiUtils
import com.test.insourcetake2.contracts.BasePresenter
import com.test.insourcetake2.contracts.OrderPresenterInterface
import com.test.insourcetake2.model.OrderDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrdersPresenter : OrderPresenterInterface.Presenter, BasePresenter<OrderPresenterInterface.View>() {

    val networkCall: ApiUtils = ApiUtils()

    override fun updateOrder(id: Int, data: OrderDetails) {
        networkCall.getServiceClass()?.updateOrderById(id, data)?.enqueue(object : Callback<Order> {
            override fun onFailure(call: Call<Order>, t: Throwable) {
                getView()?.showUnsucessfulToast("Network Error")
                Log.e("Add Order Error", t.message.toString())
            }

            override fun onResponse(call: Call<Order>, response: Response<Order>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun deleteOrder(id: Int) {

        networkCall.getServiceClass()?.deleteOrderById(id)?.enqueue(object : Callback<Order> {
            override fun onFailure(call: Call<Order>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Order>, response: Response<Order>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
}