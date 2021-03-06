package com.example.lab4_kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.lab4_kotlin.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnSend = findViewById<Button>(R.id.btnSend)
        val edDrink = findViewById<EditText>(R.id.edDrink)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)
        btnSend.setOnClickListener {
            if (edDrink.length() < 1)
                Toast.makeText(this, "請輸入飲料名稱",
                    Toast.LENGTH_SHORT).show()
            else {

                val b = Bundle()

                b.putString("drink", edDrink.text.toString())
                b.putString("sugar", radioGroup.findViewById<RadioButton>
                    (radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice", radioGroup2.findViewById<RadioButton>
                    (radioGroup2.checkedRadioButtonId).text.toString())

                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }
    }
}