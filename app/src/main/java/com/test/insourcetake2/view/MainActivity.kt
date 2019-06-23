package com.test.insourcetake2.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.insourcetake2.RecyclerAdapter
import com.test.insourcetake2.contracts.MainPresenterInterface
import com.test.insourcetake2.model.Data
import com.test.insourcetake2.presenter.MainPresenter
import java.util.*


class MainActivity : AppCompatActivity(), MainPresenterInterface.View {

    lateinit var recyclerView: RecyclerView
    lateinit var orderData: ArrayList<Data>
    lateinit var dataAdapter: RecyclerAdapter
    lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.test.insourcetake2.R.layout.activity_main)

        mainPresenter = MainPresenter()

        recyclerView = findViewById(com.test.insourcetake2.R.id.rv_main)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        orderData = ArrayList<Data>()

        dataAdapter = RecyclerAdapter(this@MainActivity, orderData)

        initializeData()

        val helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or
                    ItemTouchHelper.DOWN or ItemTouchHelper.UP, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                Collections.swap(orderData, from, to)
                dataAdapter.notifyItemMoved(from, to)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                orderData.removeAt(viewHolder.adapterPosition)
                dataAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        })
        helper.attachToRecyclerView(recyclerView)

    }

    private fun initializeData() {

        orderData.clear()

        showProgressbar()
        orderData = mainPresenter.getOrders() as ArrayList<Data>
        hideProgressBar()

        dataAdapter.notifyDataSetChanged()

    }

    override fun showProgressbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSucessfullToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }

    override fun showUnsucessfulToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }


}
