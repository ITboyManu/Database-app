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
import kotlin.math.sign

class Signup : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var email: EditText
    lateinit var password:EditText
    lateinit var confirm:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth= Firebase.auth
         email=findViewById<EditText>(R.id.editTextTextEmailAddress)
        password=findViewById<EditText>(R.id.editTextTextPassword)
         confirm=findViewById<EditText>(R.id.editTextTextPassword2)
        val signup=findViewById<Button>(R.id.button)
        val login=findViewById<TextView>(R.id.textView6)
        // coding of shift the login screen
        login.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        // Coding of signup button
        signup.setOnClickListener {

                signUser()
        }

    }
// Function or working of singup screen
    private fun signUser() {
        var eemail=email.text.toString()
        val epassword=password.text.toString()
        val reenter=confirm.text.toString()
        if ((eemail==null)&&(epassword==null)&&(reenter==null))
        {
           Toast.makeText(this,"please enter all field",Toast.LENGTH_SHORT).show()
        }
    else if (epassword!=reenter)
        {
        Toast.makeText(this,"password not match",Toast.LENGTH_LONG).show()
    }
    else{
        auth.createUserWithEmailAndPassword(eemail,epassword).addOnCompleteListener {
            if(it.isSuccessful)
            {
                Toast.makeText(this,"Create and account successfull",Toast.LENGTH_LONG).show()
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Login fail",Toast.LENGTH_LONG).show()
            }

        }
    }
    }
}