package com.example.pregapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class page_9 : AppCompatActivity() {
    private var check1: Boolean = false
    private var check2: Boolean = false
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page9)

        auth = Firebase.auth
        val inputEmail = findViewById<EditText>(R.id.page9_editText2)
        val inputPassword = findViewById<EditText>(R.id.page9_editText3)
        inputChanged(inputEmail, inputPassword)

        val button1 = findViewById<Button>(R.id.page9_button1)
        button1.isEnabled = false
        button1.setOnClickListener{
            val email: String = inputEmail?.text.toString().trim() { it <= ' ' }
            val password: String = inputPassword?.text.toString().trim() { it <= ' ' }
            loginAccount(email, password)
        }
    }

    private fun inputChanged(inputEmail:EditText, inputPassword: EditText) {
        inputEmail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                emailValidation(inputEmail)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        inputPassword.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                passwordValidation(inputPassword)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun emailValidation(inputEmail: EditText) {
        val login: String = inputEmail.text.toString().trim() {it <= ' '}
        check1 = login.isNotEmpty()
        sumCheck()
    }

    private fun passwordValidation(inputPassword: EditText) {
        val password: String = inputPassword.text.toString().trim() { it <= ' ' }
        check2 = password.isNotEmpty()
        sumCheck()
    }

    private fun sumCheck() {
        val button1 = findViewById<Button>(R.id.page9_button1)
        button1.isEnabled = check1 && check2 == true
    }

    private fun loginAccount(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Log.d(TAG, "signInWithEmail:success")
                Toast.makeText(baseContext, "Logowanie powiodło się", Toast.LENGTH_SHORT).show()
                val user = auth.currentUser
                updateUI(user)
                val page12 = Intent(applicationContext, page_12::class.java)
                startActivity(page12)
            } else {
                Log.w(TAG, "signInWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Logowanie nie powiodło się", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}