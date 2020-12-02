package com.example.particekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var bt:Button
    private var Jasper:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt=findViewById(R.id.button)
        bt.setOnClickListener{
            Jasper="Jasper-Cheng"
        }
    }
}
