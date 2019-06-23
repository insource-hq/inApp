package com.test.insourcetake2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.insourcetake2.R
import com.test.insourcetake2.contracts.OrderPresenterInterface

class OrderActivity : AppCompatActivity(), OrderPresenterInterface.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
    }

    override fun showOrderDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSucessfullToast(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUnsucessfulToast(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
