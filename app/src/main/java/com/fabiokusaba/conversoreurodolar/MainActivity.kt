package com.fabiokusaba.conversoreurodolar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fabiokusaba.conversoreurodolar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener {
            converterValor(0.8)
        }

        binding.buttonPeso.setOnClickListener {
            converterValor(10.2)
        }

        binding.buttonReal.setOnClickListener {
            converterValor(5.0)
        }
    }

    private fun converterValor(taxa: Double) {
        val euros = binding.editEuros.text.toString().trim()

        if (!euros.isEmpty()) {
            val dolares = String.format("%.2f", euros.toDouble() * taxa)
            Toast.makeText(applicationContext, "$dolares$", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "Por favor, insira um valor em Euro", Toast.LENGTH_SHORT).show()
        }
    }
}