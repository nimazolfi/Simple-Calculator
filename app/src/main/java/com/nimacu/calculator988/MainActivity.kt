// LET'S DO THIS AND BUILD A CALCULATOR ...
//

package com.nimacu.calculator988

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.Toast
import com.nimacu.calculator988.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    // Create binding view
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Numbers function
        onNumberClicked()

        // Operations function
        onOperateClicked()

    }

    // Operations function
    private fun onOperateClicked() {

        // Plus button
        binding.btnPlus.setOnClickListener {

            // Checking the first entry so that it is not empty
            if (binding.txtOperation.text.isNotEmpty()) {

                // create a value to have the last character
                val txt = binding.txtOperation.text.last()

                // Create a condition so that repeated operations do not follow each other
                if (
                    txt != '+' &&
                    txt != '-' &&
                    txt != '/' &&
                    txt != '*'
                ) {

                    // Conditions checked and appending +
                    appendText("+")

                }

            }

        }

        // Minus button
        binding.btnMinus.setOnClickListener {

            // Checking the first entry so that it is not empty
            if (binding.txtOperation.text.isNotEmpty()) {

                // create a value to have the last character
                val txt = binding.txtOperation.text.last()

                // Create a condition so that repeated operations do not follow each other
                if (
                    txt != '+' &&
                    txt != '-' &&
                    txt != '/' &&
                    txt != '*'
                ) {

                    // Conditions checked and appending -
                    appendText("-")

                }

            }

        }

        // Multiply button
        binding.btnMultiply.setOnClickListener {

            // Checking the first entry so that it is not empty
            if (binding.txtOperation.text.isNotEmpty()) {

                // create a value to have the last character
                val txt = binding.txtOperation.text.last()

                // Create a condition so that repeated operations do not follow each other
                if (
                    txt != '+' &&
                    txt != '-' &&
                    txt != '/' &&
                    txt != '*'
                ) {

                    // Conditions checked and appending *
                    appendText("*")

                }

            }

        }

        // Division button
        binding.btnDivision.setOnClickListener {

            // Checking the first entry so that it is not empty
            if (binding.txtOperation.text.isNotEmpty()) {

                // create a value to have the last character
                val txt = binding.txtOperation.text.last()

                // Create a condition so that repeated operations do not follow each other
                if (
                    txt != '+' &&
                    txt != '-' &&
                    txt != '/' &&
                    txt != '*'
                ) {

                    // Conditions checked and appending *
                    appendText("/")

                }

            }

        }

        // Open brace button
        binding.btnOpenBrace.setOnClickListener {

            // Appending (
            appendText("(")
        }

        // Close brace button
        binding.btnCloseBrace.setOnClickListener {

            // Appending )
            appendText(")")
        }

        // AC button ==> Clear all data
        binding.btnAC.setOnClickListener {

            // Clear the information section
            binding.txtOperation.text = ""

            // Clear the result section
            binding.txtResult.text = ""

        }

        // Backspace button
        binding.btnBack.setOnClickListener {

            // Create a value to have old result
            val oldText = binding.txtOperation.text

            // Checking the result to not be empty
            if (oldText.isNotEmpty()){

                // Give the old result to delete the last entry
                binding.txtOperation.text = oldText.substring(0, oldText.length - 1)

            }

        }

        // Equal button
        binding.btnEqual.setOnClickListener {

            // Create try catch loop to getting result with custom conditions
            try {

                //
                val expression = ExpressionBuilder(binding.txtOperation.text.toString()).build()

                // Getting result with evaluate method
                val result = expression.evaluate()

                // Conversion result to long if it's not a double
                val longRes = result.toLong()

                // Check the result is double or long
                if (result == longRes.toDouble()) {

                    // The condition is met and result will be show as long
                    binding.txtResult.text = longRes.toString()

                } else {

                    // The condition isn't met and result will be show as double
                    binding.txtResult.text = result.toString()

                }

            // Try loop isn't met and will enter to catch loop
            }catch (e : Exception){

                // Clear all entered data
                binding.txtOperation.text = ""

                // Clear all result data
                binding.txtResult.text = ""

                // Create a toast to show the ERROR!
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()

            }

        }

    }

    // Numbers function
    private fun onNumberClicked() {

        // Zero button
        binding.btn0.setOnClickListener {

            // Checking the first entry to not be zero
            if (binding.txtOperation.text.isNotEmpty()){

                // Appending zero as data
                appendText("0")

            }

        }

        // Number one button
        binding.btn1.setOnClickListener {

            // Appending one as data
            appendText("1")

        }

        // Number two button
        binding.btn2.setOnClickListener {

            // Appending two as data
            appendText("2")

        }

        // Number three button
        binding.btn3.setOnClickListener {

            // Appending three as data
            appendText("3")

        }

        // Number four button
        binding.btn4.setOnClickListener {

            // Appending four as data
            appendText("4")

        }

        // Number five button
        binding.btn5.setOnClickListener {

            // Appending five as data
            appendText("5")

        }

        // Number six button
        binding.btn6.setOnClickListener {

            // Appending six as data
            appendText("6")

        }

        // Number seven button
        binding.btn7.setOnClickListener {

            // Appending seven as data
            appendText("7")

        }

        // Number eight button
        binding.btn8.setOnClickListener {

            // Appending eight as data
            appendText("8")

        }

        // Number nine button
        binding.btn9.setOnClickListener {

            // Appending nine as data
            appendText("9")

        }

        // Dot button
        binding.btnDot.setOnClickListener {

            // Create a condition to send dot with zero if it's empty for doubles less than one
            if (binding.txtOperation.text.isEmpty() || binding.txtResult.text.isNotEmpty()){

                // Append dot with zero if data is clear
                appendText("0.")

                // Check the last character to see it's operation or no
                // If it's an operation send dot with zero
            }else if (binding.txtOperation.text.takeLast(1) != "."){

                // Check the conditions to know the last char
                if (
                    (binding.txtOperation.text.last() == '+') or
                    (binding.txtOperation.text.last() == '-') or
                    (binding.txtOperation.text.last() == '*') or
                    (binding.txtOperation.text.last() == '/')
                ) {

                    // Conditions checked and append dot
                    appendText("0.")

                    // If condition is not met , else will be checked
                }else {

                    // Check the last character to see it's dot or nope
                    if (!binding.txtOperation.text.takeLast(3).contains('.')) {

                        // If condition is met , append dot
                        appendText(".")

                    }
                    
                }

            }

//            // Create a condition to send dot with zero if it's empty for doubles less than one
//            if (binding.txtOperation.text.isEmpty() || binding.txtResult.text.isNotEmpty()) {
//
//                // Append dot with zero if data is clear
//                appendText("0.")
//
//                // Check to see there is any data or nope
//            }else if (!binding.txtOperation.text.contains(".")){
//
//                // Appending single dot if there is any data before
//                appendText(".")
//
//            }

        }

    }

    // Get data to do operation
    // This function will be call at other functions members
    private fun appendText(newText:String){

        // Create a condition to know result is empty or not
        if (binding.txtResult.text.isNotEmpty()){

            // If condition is met , text will be clear
            binding.txtOperation.text = ""

        }

        // Create result box empty
        binding.txtResult.text = ""

        // Appending the data that's get from other functions
        binding.txtOperation.append(newText)

        // The below code help the program to scroll the entered data to side
        val vto :ViewTreeObserver = binding.txtOperation.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                binding.txtOperation.viewTreeObserver.removeOnGlobalLayoutListener(this)
                binding.txtOperation.scrollTo(binding.txtOperation.width, 0)
            }
        })

    }
}