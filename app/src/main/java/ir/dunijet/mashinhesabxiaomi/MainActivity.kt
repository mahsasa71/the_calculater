package ir.dunijet.mashinhesabxiaomi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.Toast
import ir.dunijet.mashinhesabxiaomi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.Objects

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onopratorClicked()
        onNumberClicked()
    }

    private fun onopratorClicked() {

        binding.btnMenha.setOnClickListener {
            if (binding.txtbala.text.isNotEmpty()){
            val mychar = binding.txtbala.text.last()
            if (mychar != '+' && mychar != '-' && mychar != '*' && mychar != '/') {
                appendText("-")
            }


        }
    }
        binding.btnJam.setOnClickListener {
            if (binding.txtbala.text.isNotEmpty()) {
                val mychar = binding.txtbala.text.last()
                if (mychar != '+' && mychar != '-' && mychar != '*' && mychar != '/') {
                    appendText("+")
                }
            }
        }
        binding.btnTaghsim.setOnClickListener {
            if (binding.txtbala.text.isNotEmpty()) {
                val mychar = binding.txtbala.text.last()
                if (mychar != '+' && mychar != '-' && mychar != '*' && mychar != '/') {
                    appendText("/")
                }

            }
        }
        binding.btnZarb.setOnClickListener {
            if (binding.txtbala.text.isNotEmpty()) {
                val mychar = binding.txtbala.text.last()
                if (mychar != '+' && mychar != '-' && mychar != '*' && mychar != '/') {
                    appendText("*")
                }
            }
        }
        binding.btnpbaste.setOnClickListener {

            appendText(")")

        }
        binding.btnpbaz.setOnClickListener {
            appendText("(")

        }
        binding.btnPakidan.setOnClickListener {
            var oldtext=binding.txtbala.text.toString()
            if (oldtext.isNotEmpty())
            {
                binding.txtbala.text=oldtext.substring(0,oldtext.length-1)

            }


        }
        binding.btnAc.setOnClickListener {
            binding.txtbala.text=""
            binding.txtpaeen.text=""

        }
        binding.btnDot.setOnClickListener {


            if (binding.txtbala.text.isEmpty() || binding.txtpaeen.text.isNotEmpty()) {
                appendText("0.")


            } else if ((binding.txtbala.text.last()) != '.') {
                appendText(".")


            }
        }

            binding.btnMosavi.setOnClickListener {
                try {

                    val expression = ExpressionBuilder(binding.txtbala.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble()) {
                        binding.txtpaeen.text = longResult.toString()

                    } else {
                        binding.txtpaeen.text = result.toString()
                    }

                }catch (error:java.lang.Exception){
                    Toast.makeText(this, " طفا دوتا عملیات را پشت هم نزن :) ", Toast.LENGTH_LONG).show()
                }
            }








    }


    private fun onNumberClicked() {
        binding.btn0.setOnClickListener {
            if(binding.txtbala.text.isNotEmpty()){
                appendText("0")
            }


        }
        binding.btn1.setOnClickListener {

            appendText("1")

        }
        binding.btn2.setOnClickListener {
            appendText("2")

        }
        binding.btn3.setOnClickListener {
            appendText("3")

        }
        binding.btn4.setOnClickListener {
            appendText("4")

        }
        binding.btn5.setOnClickListener {
            appendText("5")

        }
        binding.btn6.setOnClickListener {
            appendText("6")

        }
        binding.btn7.setOnClickListener {
            appendText("7")

        }
        binding.btn8.setOnClickListener {
            appendText("8")

        }
        binding.btn9.setOnClickListener {
            appendText("9")

        }

    }
    private fun appendText(txt:String){

        if (binding.txtpaeen.text.isNotEmpty()){
            binding.txtbala.text=""
        }
        binding.txtpaeen.text=""
        binding.txtbala.append(txt)

        val veitree:ViewTreeObserver=binding.scrool.viewTreeObserver
        veitree.addOnGlobalLayoutListener(object :ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                binding.scrool.viewTreeObserver.removeOnGlobalLayoutListener(this)
                binding.scrool.scrollTo(binding.txtbala.width,0)
            }

        })

    }
}