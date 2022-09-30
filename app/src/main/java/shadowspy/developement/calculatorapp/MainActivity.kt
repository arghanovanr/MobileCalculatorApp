package shadowspy.developement.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException


class MainActivity : AppCompatActivity() {

    //TextValue
    private var txtNumberView : TextView? = null

    //LastNumberChecker
    var lastNumeric = false
    var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TextView Number ID
        txtNumberView = findViewById(R.id.textNumberView)

        //All Button Number ID
        val buttonNumber0 : Button = findViewById(R.id.button0)
        val buttonNumber1 : Button = findViewById(R.id.button1)
        val buttonNumber2 : Button = findViewById(R.id.button2)
        val buttonNumber3 : Button = findViewById(R.id.button3)
        val buttonNumber4 : Button = findViewById(R.id.button4)
        val buttonNumber5 : Button = findViewById(R.id.button5)
        val buttonNumber6 : Button = findViewById(R.id.button6)
        val buttonNumber7 : Button = findViewById(R.id.button7)
        val buttonNumber8 : Button = findViewById(R.id.button8)
        val buttonNumber9 : Button = findViewById(R.id.button9)
        val buttonDecimal : Button = findViewById(R.id.buttonDecimal)
        val buttonClear   : Button = findViewById(R.id.buttonClear)
        val buttonAdding  : Button = findViewById(R.id.buttonAdding)
        val buttonSubstraction : Button = findViewById(R.id.buttonSubstraction)
        val buttonMultiplication : Button = findViewById(R.id.buttonMultiplication)
        val buttonDivide : Button = findViewById(R.id.buttonDivide)
        val buttonSubmit : Button = findViewById(R.id.buttonSubmit)

        //OnClick for numeric button
        buttonNumber0.setOnClickListener(){
            addChar(buttonNumber0)
        }
        buttonNumber1.setOnClickListener(){
            addChar(buttonNumber1)
        }
        buttonNumber2.setOnClickListener(){
            addChar(buttonNumber2)
        }
        buttonNumber3.setOnClickListener(){
            addChar(buttonNumber3)
        }
        buttonNumber4.setOnClickListener(){
            addChar(buttonNumber4)
        }
        buttonNumber5.setOnClickListener(){
            addChar(buttonNumber5)
        }
        buttonNumber6.setOnClickListener(){
            addChar(buttonNumber6)
        }
        buttonNumber7.setOnClickListener(){
            addChar(buttonNumber7)
        }
        buttonNumber8.setOnClickListener(){
            addChar(buttonNumber8)
        }
        buttonNumber9.setOnClickListener(){
            addChar(buttonNumber9)
        }

        //OnClick for Clearing button
        buttonClear.setOnClickListener(){
            clearTxt()
        }

        //OnClick for Decimal button
        buttonDecimal.setOnClickListener(){
            addDecimal()
        }

        //OnClick for Operator button
        buttonAdding.setOnClickListener(){
            onOperator(buttonAdding)
        }
        buttonDivide.setOnClickListener(){
            onOperator(buttonDivide)
        }
        buttonMultiplication.setOnClickListener(){
            onOperator(buttonMultiplication)
        }
        buttonSubstraction.setOnClickListener(){
            onOperator(buttonSubstraction)
        }

        //OnClick for Submit button
        buttonSubmit.setOnClickListener(){
            onEqual(buttonSubmit)
        }
    }

    //Function
    private fun addChar(view : View){
        txtNumberView?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    private fun clearTxt(){
        txtNumberView?.text = ""
        lastNumeric = false
        lastDot = false
    }

    private fun addDecimal(){
        if(lastNumeric && !lastDot){
            txtNumberView?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    private fun onOperator(view : View ){
        txtNumberView?.text?.let {
            if(lastNumeric && !checkOperator(it.toString())){
                txtNumberView?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }

    }

    private fun onEqual(view : View){
        if(lastNumeric){
            var tvValue = txtNumberView?.text.toString()

            var prefix = ""
            try {

                if(tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if(tvValue.contains("-")){   // Check for substraction operation
                    val arrayValue = tvValue.split("-")

                    var firstVar  = arrayValue[0]
                    var secondVar = arrayValue[1]

                    if(prefix.isNotEmpty()){
                        firstVar = prefix + firstVar;
                    }

                    txtNumberView?.text = dotRemover((firstVar.toDouble() - secondVar.toDouble()).toString())
                }else if (tvValue.contains("+")){   // Check for Adding operation
                    val arrayValue = tvValue.split("+")

                    var firstVar  = arrayValue[0]
                    var secondVar = arrayValue[1]

                    if(prefix.isNotEmpty()){
                        firstVar = prefix + firstVar;
                    }

                    txtNumberView?.text = dotRemover((firstVar.toDouble() + secondVar.toDouble()).toString())
                }else if (tvValue.contains("/")){   // Check for Divide operation
                    val arrayValue = tvValue.split("/")

                    var firstVar  = arrayValue[0]
                    var secondVar = arrayValue[1]

                    if(prefix.isNotEmpty()){
                        firstVar = prefix + firstVar;
                    }

                    txtNumberView?.text = dotRemover((firstVar.toDouble() / secondVar.toDouble()).toString())
                } else if (tvValue.contains("*")){   // Check for Multiplication operation
                    val arrayValue = tvValue.split("*")

                    var firstVar  = arrayValue[0]
                    var secondVar = arrayValue[1]

                    if(prefix.isNotEmpty()){
                        firstVar = prefix + firstVar;
                    }

                    txtNumberView?.text = dotRemover((firstVar.toDouble() * secondVar.toDouble()).toString())
                }


            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun dotRemover (result :String ) : String {
        var value = result
        if(result.contains(".0")){
            value = result.substring(0, result.length-2)
        }
        return value
    }

    private fun checkOperator (value :String): Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("-") ||
            value.contains("+") ||
            value.contains("*") ||
            value.contains("/")
        }
    }

}