package com.example.decisionmaking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enteredAmount = findViewById<EditText>(R.id.editTextAmount)
        val convertCurrency = findViewById<Button>(R.id.buttonConvert)
        var convertedAmount = 0.00
        var convertedAmountStr = ""

        convertCurrency.setOnClickListener {
            val radioButton = findViewById<RadioGroup>(R.id.radioGroup)
            val selectedOptionID = radioButton.checkedRadioButtonId
            val selectedOption = findViewById<RadioButton>(selectedOptionID)

            if (selectedOption.text.toString() == "Convert Dollars to Euros"){
                convertedAmount = enteredAmount.text.toString().toDouble() * 0.94
                convertedAmountStr = "€$convertedAmount"
            }
            else if (selectedOption.text.toString() == "Convert Euros to Dollars"){
                convertedAmount = enteredAmount.text.toString().toDouble() * 1.06
                convertedAmountStr = "$$convertedAmount"
            }
            Toast.makeText(this, convertedAmountStr, Toast.LENGTH_SHORT).show()
        }
    }
}