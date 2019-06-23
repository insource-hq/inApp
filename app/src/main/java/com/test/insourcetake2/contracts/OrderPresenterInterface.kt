package com.test.insourcetake2.contracts

import com.test.insourcetake2.model.OrderDetails

interface OrderPresenterInterface {


    interface Presenter {
        //Update the order
        fun updateOrder(id: Int, data: OrderDetails)

        //delete the order
        fun deleteOrder(id: Int)
    }

    interface View {
        //to view the order details
        fun showOrderDetails()

        fun showProgressbar()
        fun hideProgressBar()

        fun showSucessfullToast(message: String)
        fun showUnsucessfulToast(message: String)

    }


}