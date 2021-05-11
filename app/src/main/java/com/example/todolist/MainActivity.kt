package com.example.todolist

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener{


    override fun onCreate(savedInstanceState: Bundle?) { // automatically running when code is starting
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // which page running

        // dinamic date
        val textView: TextView = findViewById(R.id.dateAndTime)
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy ")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime

        //check box
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)

        checkBox1.setOnClickListener(this)
        checkBox2.setOnClickListener(this)
        checkBox3.setOnClickListener(this)
        checkBox4.setOnClickListener(this)

        var sharedPreferences = this.getSharedPreferences("com.example.todolist",Context.MODE_PRIVATE)


        var editor =sharedPreferences.edit()

        //
        /*editor.putString("firstItem", editText1.text.toString()).apply()
        editor.putString("secondItem", editText2.text.toString()).apply()
        editor.putString("thirdItem", editText3.text.toString()).apply()
        editor.putString("fourthItem", editText4.text.toString()).apply()*/

        var saved1= sharedPreferences.getString("firstItem","").toString()
        editText1.setText(saved1)
        var saved2= sharedPreferences.getString("secondItem","").toString()
        editText2.setText(saved2)
        var saved3= sharedPreferences.getString("thirdItem","").toString()
        editText3.setText(saved3)
        var saved4= sharedPreferences.getString("fourthItem","").toString()
        editText4.setText(saved4)

        buttonSave.setOnClickListener{
            var saved1 = editText1.text.toString()
            sharedPreferences.edit().putString("firstItem" ,saved1).apply()

            var saved2 = editText2.text.toString()
            sharedPreferences.edit().putString("secondItem" ,saved2).apply()

            var saved3 = editText3.text.toString()
            sharedPreferences.edit().putString("thirdItem" ,saved3).apply()

            var saved4 = editText4.text.toString()
            sharedPreferences.edit().putString("fourthItem" ,saved4).apply()





        }


    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked :Boolean = v.isChecked
        when(v.id){
            R.id.checkBox1 -> if(isChecked){
                print("tick1 is markable")
            }
            R.id.checkBox2 -> if(isChecked)
            {
                print("tick2 is markable")
            }
            R.id.checkBox3 -> if(isChecked)
            {
                print("tick3 is markable")
            }
            R.id.checkBox4 -> if(isChecked)
            {
                print("tick3 is markable")
            }
        }

        }


    }



