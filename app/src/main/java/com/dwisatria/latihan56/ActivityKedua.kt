package com.dwisatria.latihan56

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityKedua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kedua)

        //get data from intent
        val bundle:Bundle = intent.extras
        val intent = intent
        val mySpinner = intent.getStringExtra("mySpinner")
        val editDate= intent.getStringExtra("editDate")

        //textview
        val result = findViewById<TextView>(R.id.result)
        //setText
        result.text =
            "Prodi : " + mySpinner + "\nTanggal : " + editDate
    }

}