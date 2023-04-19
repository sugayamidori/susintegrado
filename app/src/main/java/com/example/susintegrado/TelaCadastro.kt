package com.example.susintegrado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.susintegrado.databinding.ActivityMainBinding
import com.example.susintegrado.databinding.ActivityTelaCadastroBinding

class TelaCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityTelaCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCriarCadastro.setOnClickListener{
            val navegarAcessoProfissional = Intent(this, AcessoProfissional::class.java)
            startActivity(navegarAcessoProfissional)
        }

        binding.voltarLogin.setOnClickListener{
            val voltarLogin = Intent(this, MainActivity::class.java)
            startActivity(voltarLogin)
        }
    }
}