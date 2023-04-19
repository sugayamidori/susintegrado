package com.example.susintegrado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.susintegrado.databinding.ActivityMainBinding
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btEntrar.setOnClickListener {
            val navegarAcessoProfissional = Intent(this, AcessoProfissional::class.java)
            startActivity(navegarAcessoProfissional)
            }


        binding.textCriarConta.setOnClickListener {
            val navegarTelaCadastro = Intent(this, TelaCadastro::class.java)
            startActivity(navegarTelaCadastro)
        }
        /*val buttEntrar = binding.btEntrar
        buttEntrar.setOnClickListener {
            val navegarAcessoProfissional = Intent(this, AcessoProfissional::class.java)
            startActivity(navegarAcessoProfissional)
            }*/


    }
    }
