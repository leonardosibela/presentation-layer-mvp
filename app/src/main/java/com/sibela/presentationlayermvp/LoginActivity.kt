package com.sibela.presentationlayermvp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginTask.View {

    private lateinit var presenter: LoginTask.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        loginButton.setOnClickListener { login() }
    }

    private fun login() {
        val email = editTextTextEmailAddress.text.toString()
        val password = editTextTextPassword.text.toString()
        presenter.loginUser(email, password)
    }

    override fun displayLoading() {
        displayProgressBar()
        hideForm()
    }

    private fun hideForm() {
        editTextTextEmailAddress.visibility = View.INVISIBLE
        editTextTextPassword.visibility = View.INVISIBLE
    }

    private fun displayProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun displayUserNotFound() {
        hideProgressBar()
        displayForm()
        Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show()
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun displayInvalidUserOrPassword() {
        hideProgressBar()
        displayForm()
        Toast.makeText(this, "Invalid user or password", Toast.LENGTH_LONG).show()
    }

    private fun displayForm() {
        editTextTextEmailAddress.visibility = View.VISIBLE
        editTextTextPassword.visibility = View.VISIBLE
    }

    override fun onLoggedIn() {
        hideProgressBar()
        displayForm()
        Toast.makeText(this, "User logged in", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}