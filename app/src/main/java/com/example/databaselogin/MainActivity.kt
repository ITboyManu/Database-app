package com.example.databaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    lateinit var email:EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth= Firebase.auth
        val login=findViewById<Button>(R.id.button)
        val signup=findViewById<TextView>(R.id.textView6)
        email=findViewById<EditText>(R.id.editTextTextEmailAddress)
        password=findViewById<EditText>(R.id.editTextTextPassword)

        signup.setOnClickListener {
            val intent= Intent(this,Signup::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            loginuser()
        }
    }

    private fun loginuser() {
        val eemail=email.text.toString()
        val epassword=password.text.toString()
        if ((eemail==null)&&(password==null))
        {
            Toast.makeText(this,"Email password fill correctly",Toast.LENGTH_LONG).show()

        }
        else
        {
            auth.signInWithEmailAndPassword(eemail,epassword).addOnCompleteListener {
                if (it.isSuccessful)
                {
                    Toast.makeText(this,"login successfull",Toast.LENGTH_LONG).show()
                    val intent=Intent(this,Welcome::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this,"login failed",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}