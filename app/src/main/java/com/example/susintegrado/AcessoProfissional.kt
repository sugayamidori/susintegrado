package com.example.susintegrado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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

        var navegarAcessoProfissional = intent
        val name = intent.getStringExtra("EXTRA_EDIT_NAME")
        val macessoProfissional : TextView = findViewById(R.id.acesso_profissional)
        macessoProfissional.setText(name + ", logado com \nAcesso Profissional")

    }
}