package com.example.susintegrado

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.susintegrado.databinding.ActivityMainBinding
import com.example.susintegrado.databinding.ActivityTelaCadastroBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TelaCadastro : AppCompatActivity() {



    private lateinit var binding: ActivityTelaCadastroBinding

    //adicionei vendo o vídeo para cadastro com Firebase
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val medit_name = findViewById<EditText>(R.id.edit_name)
        val mbt_criar_cadastro = findViewById<Button>(R.id.bt_criar_cadastro)

        binding.btCriarCadastro.setOnClickListener{
            var name = medit_name.text.toString()
            val navegarAcessoProfissional = Intent(this, AcessoProfissional::class.java)
            navegarAcessoProfissional.putExtra("EXTRA_EDIT_NAME", name)
            startActivity(navegarAcessoProfissional)

            //adicionei vendo o vídeo para cadastro com Firebase

                auth.signInWithEmailAndPassword(binding.editEmail.text.toString(),binding.editSenha.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCustomToken:success")
                            val user = auth.currentUser
                            Toast.makeText(baseContext, "Autenticação efetuada",
                                Toast.LENGTH_SHORT).show()
                            //updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCustomToken:failure", task.exception)
                            Toast.makeText(baseContext, "Erro de autenticação",
                                Toast.LENGTH_SHORT).show()
                            //updateUI(null)
                        }
                    }

        }
        //adicionei vendo o vídeo para cadastro com Firebase
        binding.voltarLogin.setOnClickListener{
            val voltarLogin = Intent(this, MainActivity::class.java)
            startActivity(voltarLogin)
        }
        //adicionei vendo o vídeo para cadastro com Firebase
        auth = Firebase.auth

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        //val currentUser = auth.currentUser
        //updateUI(currentUser)
    }
}

private fun FirebaseAuth.signInWithEmailAndPassword() {

}

private fun FirebaseAuth.signInWithEmailAndPassword(email: String) {

}
