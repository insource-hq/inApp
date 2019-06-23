package com.test.insourcetake2.apiUtils

import com.test.insourcetake2.model.AuthToken
import com.test.insourcetake2.model.Data
import com.test.insourcetake2.model.Order
import com.test.insourcetake2.model.OrderDetails
import retrofit2.Call
import retrofit2.http.*


interface RetrofitInterface {

    @get:GET("orders")
    val orders: Call<Order>

    @POST("login?")
    fun getToken(@Query("email") email: String, @Query("password") password: String): Call<AuthToken>

    @POST("register")
    fun register(
        @Query("firstname") firstname: String, @Query("lastname") lastname: String, @Query("email") email: String,
        @Query("password") password: String, @Query("password_confirm") passwordConfirm: String, @Query("phonenumber") phonenumber: Int,
        @Query("employeenumber") employeenumber: Int, @Query("position") position: String, @Query("companyname") companyname: String,
        @Query("linkedin") linkedin: String
    ): Call<AuthToken>

    @POST("orders")
    fun addOrder(
        @Query("title") title: String?,
        @Query("description") description: String?,
        @Query("category_id") category_id: Int,
        @Query("free_time") free_time: String?
    ): Call<Order>  //Careful with the Free_time format bro

    @GET("orders/{id}")
    fun getOrdersById(@Path("id") id: Int): Call<Data>

    @PUT("orders/{id}")
    @Headers("Content-Type:application/json")
    fun updateOrderById(@Path("id") id: Int, @Body data: OrderDetails): Call<Order>

    @DELETE("orders/{id}")
    fun deleteOrderById(@Path("id") id: Int): Call<Order>


}
