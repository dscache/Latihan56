package com.dwisatria.latihan56

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
        var edDate: EditText?=null
        var cal=Calendar.getInstance()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            edDate = this.editDate

            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(
                        view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int
                ) {
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    updateDateInView()
                }
            }

            edDate!!.setOnClickListener(object:View.OnClickListener{
                override fun onClick(view: View){
                        DatePickerDialog(this@MainActivity,
                        dateSetListener,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
                    }
                })

            val mySpinner = findViewById<Spinner>(R.id.mySpinner)
            val editDate = findViewById<EditText>(R.id.editDate)
            val btnproses = findViewById<Button>(R.id.btnproses)

            //handle button click
            btnproses.setOnClickListener {
                //get text from edittexts
                val mySpinner = mySpinner.selectedItem.toString()
                val editDate = editDate.text.toString()

                //intent to start activity
                val intent = Intent(this@MainActivity, ActivityKedua::class.java)
                intent.putExtra("mySpinner", mySpinner)
                intent.putExtra("editDate", editDate)
                startActivity(intent)
                }
            }

            private fun updateDateInView(){
                val myFormat = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)

                edDate!!.setText(sdf.format(cal.getTime()))
            }
}