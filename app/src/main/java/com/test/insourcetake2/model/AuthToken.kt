package com.test.insourcetake2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AuthToken {
    @SerializedName("token")
    @Expose
    private var token: String? = null
    @SerializedName("message")
    @Expose
    private var message: String? = null
    @SerializedName("status")
    @Expose
    private var status: Boolean? = null

    fun getToken(): String? {
        return token
    }

    fun setToken(token: String) {
        this.token = token
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getStatus(): Boolean? {
        return status
    }

    fun setStatus(status: Boolean?) {
        this.status = status
    }


}
