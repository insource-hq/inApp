package com.test.insourcetake2.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.test.insourcetake2.R
import com.test.insourcetake2.apiUtils.NetworkInterface
import com.test.insourcetake2.contracts.LoginPresenterInterface
import com.test.insourcetake2.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity(), LoginPresenterInterface.View, NetworkInterface.NetworkView {


    val presenter = LoginPresenter()

    val sharedPreferences = getSharedPreferences("Login_Data", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //TODO: Handle UI events
        btn_login.setOnClickListener {

            //Check the data validation
            if(presenter.isValidEmail(et_email_login.text.toString())
                && presenter.isValidPassword(et_password_login.text.toString())) {

                presenter.requestLogin(et_email_login.text.toString(), et_password_login.text.toString())
            }

        }
    }

    override fun showSucessfullLoginToast(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()
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
