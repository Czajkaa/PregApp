package com.example.pregapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import java.math.BigInteger
import java.security.MessageDigest

class page_2 : AppCompatActivity() {
    private var check1: Boolean = false
    private var check2: Boolean = false
    private var check3: Boolean = false
    private var check4: Boolean = false
    private var check5: Boolean = false
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        auth = Firebase.auth
        val user = auth.currentUser.toString().substringAfter("com.google.firebase.auth.internal.zzaa@")
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user).child("howPeriod")

        val inputEmail = findViewById<EditText>(R.id.page2_editText2)
        val inputPassword = findViewById<EditText>(R.id.page2_editText3)
        val inputReapeatPassword = findViewById<EditText>(R.id.page2_editText4)
        val card4 = findViewById<CardView>(R.id.card4)

        inputChanged(inputEmail, inputPassword, inputReapeatPassword)

        val button1 = findViewById<Button>(R.id.page2_button1)
        button1.isEnabled = false
        button1.setOnClickListener{
            val login: String = inputEmail?.text.toString().trim() {it <= ' '}
            val password: String = inputPassword?.text.toString().trim() {it <= ' '}
            createAccount(login, password)
            inputEmail.text.clear()
            inputPassword.text.clear()
            inputReapeatPassword.text.clear()
            card4.setCardBackgroundColor(Color.RED)
        }
    }

    private fun inputChanged(inputEmail:EditText, inputPassword: EditText, inputReapeatPassword:EditText) {
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
                passwordReapeatValidation(inputPassword, inputReapeatPassword)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        inputReapeatPassword.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                passwordReapeatValidation(inputPassword, inputReapeatPassword)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun emailValidation(inputEmail:EditText) {
        val login: String = inputEmail.text.toString().trim() {it <= ' '}
        check1 = login.matches(".*[@].*".toRegex()) && login.matches(".*[.].*".toRegex())
        sumCheck()
    }

    private fun passwordValidation(inputPassword: EditText) {
        val password: String = inputPassword.text.toString().trim() {it <= ' '}
        val card1 = findViewById<CardView>(R.id.card1)
        val card2 = findViewById<CardView>(R.id.card2)
        val card3 = findViewById<CardView>(R.id.card3)

        check2 = if(password.length >= 6) {
            card1.setCardBackgroundColor(Color.GREEN)
            true
        } else {
            card1.setCardBackgroundColor(Color.RED)
            false
        }

        check3 = if(password.matches(".*\\d.*".toRegex())) {
            card2.setCardBackgroundColor(Color.GREEN)
            true
        } else {
            card2.setCardBackgroundColor(Color.RED)
            false
        }

        check4 = if(password.matches(".*[$&+,:;=?@#|'<>._^*()%!].*".toRegex())) {
            card3.setCardBackgroundColor(Color.GREEN)
            true
        } else {
            card3.setCardBackgroundColor(Color.RED)
            false
        }
        sumCheck()
    }

    private fun passwordReapeatValidation(inputPassword: EditText, inputReapeatPassword:EditText) {
        val card4 = findViewById<CardView>(R.id.card4)
        val password: String = inputPassword.text.toString().trim() {it <= ' '}
        val passwordReapeat: String = inputReapeatPassword.text.toString().trim() {it <= ' '}

        check5 = if(password == passwordReapeat) {
            card4.setCardBackgroundColor(Color.GREEN)
            true
        } else {
            card4.setCardBackgroundColor(Color.RED)
            false
        }
        sumCheck()
    }

    private fun sumCheck() {
        val button1 = findViewById<Button>(R.id.page2_button1)
        button1.isEnabled = check1 && check2 && check3 && check4 && check5 == true
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                createUserData()
                updateUI(user)
                val page15 = Intent(applicationContext, page_15::class.java)
                startActivity(page15)
            } else {
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Email został już użyty", Toast.LENGTH_SHORT,).show()
                updateUI(null)
            }
        }
    }

    companion object {
        private const val TAG = "EmailPassword"
    }

    private fun updateUI(user: FirebaseUser?) {
    }

    private fun createUserData() {
        val user = md5(auth.currentUser?.email.toString())
        val database = FirebaseDatabase.getInstance("https://pregapp-3f832-default-rtdb.europe-west1.firebasedatabase.app").
        reference.child("UserID").child(user)
        val data = createData("brak", "0", "0", "0", "brak", "0", "0", "brak")
        database.setValue(data)
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}