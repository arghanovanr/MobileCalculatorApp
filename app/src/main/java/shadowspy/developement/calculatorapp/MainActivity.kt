package shadowspy.developement.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    //TextValue
    private var txtNumberView : TextView? = null

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
        val buttonClear   : Button = findViewById(R.id.buttonClear)
        val buttonAdding  : Button = findViewById(R.id.buttonAdding)
        val buttonSubstraction : Button = findViewById(R.id.buttonSubstraction)
        val buttonMultiplication : Button = findViewById(R.id.buttonMultiplication)
        val buttonDivide : Button = findViewById(R.id.buttonDivide)
        val buttonSubmit : Button = findViewById(R.id.buttonSubmit)

        //OnClickListener
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
        buttonClear.setOnClickListener(){
            clearTxt()
        }
    }

    //Function
    private fun addChar(view : View){
        txtNumberView?.append((view as Button).text)
    }

    private fun clearTxt(){
        txtNumberView?.text = ""
    }
}