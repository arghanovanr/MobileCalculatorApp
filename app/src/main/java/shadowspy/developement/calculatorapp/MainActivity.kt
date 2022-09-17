package shadowspy.developement.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

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

        fun addChar(view: View){

        }
    }
}