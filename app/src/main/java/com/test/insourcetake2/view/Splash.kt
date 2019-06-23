package com.test.insourcetake2.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.insourcetake2.R
import com.test.insourcetake2.contracts.SplashPresenterInterface

class Splash : AppCompatActivity() , SplashPresenterInterface.View{


    val sharedPreferences = getSharedPreferences("Login_Data", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun getToken(): String? {
        return sharedPreferences.getString("token", "")
    }
}
