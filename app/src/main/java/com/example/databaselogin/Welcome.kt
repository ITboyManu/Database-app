package com.example.databaselogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject

class Welcome : AppCompatActivity() {
    val url:String="https://meme-api.com/gimme"
    lateinit var title:TextView
    lateinit var author:TextView
    lateinit var image:ImageView
    lateinit var next:Button
    lateinit var exit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        title=findViewById<TextView>(R.id.textView2)
        author=findViewById<TextView>(R.id.textView3)
      image=findViewById<ImageView>(R.id.img)
        next=findViewById<Button>(R.id.button2)
                exit=findViewById<Button>(R.id.button3)
         next.setOnClickListener {
             MemeData()
         }
         exit.setOnClickListener {
             finish()
         }


        MemeData()
    }

    private fun MemeData() {

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->

                val jsonobject=JSONObject(response)

                title.text=jsonobject.getString("title")
                author.text=jsonobject.getString("author")
                Glide.with(this@Welcome).load( jsonobject.getString("url")).into(image)


            },
            {error ->
                Toast.makeText(this,"${error.localizedMessage}",Toast.LENGTH_LONG)
                    .show()
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}