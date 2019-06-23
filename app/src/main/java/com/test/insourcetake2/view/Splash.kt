package com.test.insourcetake2.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.test.insourcetake2.R
import com.test.insourcetake2.contracts.SplashPresenterInterface

class Splash : AppCompatActivity(), SplashPresenterInterface.View {


    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var handle = Handler()
        handle.postDelayed({ startActivity( Intent(this@Splash, LoginActivity::class.java) ) }, 1200)
        sharedPreferences = getSharedPreferences("Login_Data", Context.MODE_PRIVATE)

    }

    override fun getToken(): String? {
        return sharedPreferences.getString("token", "")
    }

}
