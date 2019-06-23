package com.test.insourcetake2.contracts

import com.test.insourcetake2.model.Data
import com.test.insourcetake2.model.OrderDetails

interface MainPresenterInterface {


    interface Presenter {
        //get all the orders
        fun getOrders(): List<Data>

        //add order
        fun addOrder(details: OrderDetails)
    }

    interface View {
        fun showProgressbar()
        fun hideProgressBar()

        fun showSucessfullToast(message: String)
        fun showUnsucessfulToast(message: String)

    }


}