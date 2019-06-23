package com.test.insourcetake2.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.test.insourcetake2.R
import com.test.insourcetake2.apiUtils.NetworkInterface
import com.test.insourcetake2.contracts.LoginPresenterInterface
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity(), LoginPresenterInterface.View, NetworkInterface.NetworkView {
    //TODO: Handle UI events


//    val presenter = LoginPresenter()

    val sharedPreferences = getSharedPreferences("Login_Data", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    override fun showSucessfullLoginToast(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUnsucessfulLoginToast(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()
    }

    override fun startMainActivity() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }


    override fun storeToken(token: String?) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }


    override fun getToken(): String? {
        return sharedPreferences.getString("token", "")
    }


    fun String.convertStringToDate(simpleDateFormatPattern: String): Date? {
        val simpleDateFormat = SimpleDateFormat(simpleDateFormatPattern, Locale.getDefault())
        var value: Date? = null
        justTry {
            value = simpleDateFormat.parse(this)
        }
        return value
    }

    /**
     * Wrapping try/catch to ignore catch block
     */
    inline fun <T> justTry(block: () -> T) = try {
        block()
    } catch (e: Throwable) {
    }


}
