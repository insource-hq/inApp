package com.test.insourcetake2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.insourcetake2.model.Data
import com.test.insourcetake2.view.OrderActivity


class RecyclerAdapter(var mContext: Context, var data: ArrayList<Data>) : RecyclerView.Adapter<RecyclerAdapter.MyVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        return MyVH(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {

        var dataElement = data.get(position)

        // bind the data to the Holder
        holder.bindTo(dataElement)
    }

    inner class MyVH
        (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        // Member Variables for the TextViews

        var title: TextView = itemView.findViewById<TextView>(R.id.title)
        var time: TextView = itemView.findViewById<TextView>(R.id.time)


        fun bindTo(dataElement: Data) {
            title.setText(dataElement.title)
            time.setText(dataElement.freeTime)
        }

        override fun onClick(v: View) {
            val detailIntent = Intent(mContext, OrderActivity::class.java)
            val dataElement = data.get(adapterPosition)
            detailIntent.putExtra("title", dataElement.title)
            detailIntent.putExtra("description", dataElement.description)
            detailIntent.putExtra("time", dataElement.freeTime)
            detailIntent.putExtra("created", dataElement.createdAt)
            mContext.startActivity(detailIntent)

        }
    }
}