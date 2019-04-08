package com.wellyimmanuel.helper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lihat.setOnClickListener{
            val intent = Intent(this, Show::class.java)
            startActivity(intent)
        }
    }
}
