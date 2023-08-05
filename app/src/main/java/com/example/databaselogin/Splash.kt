package com.example.databaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val img=findViewById<ImageView>(R.id.imageView)

            supportActionBar?.hide()
        val ani=AnimationUtils.loadAnimation(this,R.anim.my_anim)
        img.startAnimation(ani)

        Handler().postDelayed({
            val intent= Intent(this@Splash,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }

}