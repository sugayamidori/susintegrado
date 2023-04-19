package com.example.susintegrado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.susintegrado.databinding.ActivityAcessoProfissionalBinding
import com.example.susintegrado.databinding.ActivityTelaCadastroBinding

class AcessoProfissional : AppCompatActivity() {

    private lateinit var binding: ActivityAcessoProfissionalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcessoProfissionalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.voltarLogin.setOnClickListener {
            val voltarLogin = Intent(this, MainActivity::class.java)
            startActivity(voltarLogin)
        }
    }
}