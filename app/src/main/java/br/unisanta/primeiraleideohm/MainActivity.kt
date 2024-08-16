package br.unisanta.primeiraleideohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtValorU = findViewById<EditText>(R.id.edt_valorU)
        val edtValorI = findViewById<EditText>(R.id.edt_valorI)
        val edtValorR = findViewById<EditText>(R.id.edt_valorR)
        val  btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            if (edtValorI.text.toString() == "" && edtValorU.text.toString() == "" && edtValorR.text.toString() == ""){
                Toast.makeText(this, "Preencha os valores", Toast.LENGTH_SHORT).show()
            }
            else
            {
                if (edtValorI.text.toString() != "" && edtValorU.text.toString() != "" && edtValorR.text.toString() != ""){
                    Toast.makeText(this, "Preencha apenas dois valores", Toast.LENGTH_SHORT).show()
                }
                else
                {
                if (edtValorU.text.toString() == "")
                {
                    val I = edtValorI.text.toString().toFloat()
                    val R = edtValorR.text.toString().toFloat()
                    val ur = I * R
                    Toast.makeText(this, "A Voltagem é ${ur}", Toast.LENGTH_SHORT).show()
                }
                    if (edtValorI.text.toString() == ""){
                        val U = edtValorU.text.toString().toFloat()
                        val R = edtValorR.text.toString().toFloat()
                        val ir = U / R
                    Toast.makeText(this, "A Voltagem é ${ir}", Toast.LENGTH_SHORT).show()
                }
                    if (edtValorR.text.toString() == ""){
                        val U = edtValorU.text.toString().toFloat()
                        val I = edtValorI.text.toString().toFloat()

                        val rr = U / I
                    Toast.makeText(this, "A Voltagem é ${rr}", Toast.LENGTH_SHORT).show()
                }
                }
            }
        }
    }
}