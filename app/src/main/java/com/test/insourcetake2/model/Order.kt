package com.test.insourcetake2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Order {
    @SerializedName("success")
    @Expose
    private var success: Boolean? = null
    @SerializedName("data")
    @Expose
    private var data: List<Data>? = null
    @SerializedName("message")
    @Expose
    private var message: String? = null

    fun getSuccess(): Boolean? {
        return success
    }

    fun setSuccess(success: Boolean?) {
        this.success = success
    }

    fun getData(): List<Data>? {
        return data
    }

    fun setData(orderDetails: List<Data>) {
        this.data= orderDetails
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }
}
