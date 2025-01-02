package com.example.conversoreurodolar

import android.R.attr.text
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversoreurodolar.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val euro = binding.txtEuro

        val buttons = listOf<Button>(
            binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9,
            binding.btnDelete, binding.btnClear
        )

        for (button in buttons) {
            button.setOnClickListener {
                euro.append((it as Button).text)
            }
        }



        binding.btnConvert.setOnClickListener {
            if(binding.txtEuro.text.toString().isNotEmpty()) {
            val _euro = binding.txtEuro.text.toString().toDouble()
            val conve = String.format("%.2f", _euro * 1.04)
            binding.txtResult.text = "$conve $"
            } else {
                Toast.makeText(this, "Valor Invalido", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnClear.setOnClickListener {

            if(binding.txtEuro.text.toString().isNotEmpty()) {
                binding.txtEuro.text = ""
                binding.txtResult.text = ""
            }
        }

        binding.btnDelete.setOnClickListener {
            val text = euro.text.toString()
            if (text.isNotEmpty()) {
                euro.text = text.substring(0, text.length - 1).toEditable()
            }
        }

    }
    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

}