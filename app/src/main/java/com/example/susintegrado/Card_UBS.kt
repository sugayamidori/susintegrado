package com.example.susintegrado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.susintegrado.databinding.ActivityAcessoProfissionalBinding
import com.example.susintegrado.databinding.ActivityCardUbsBinding
import com.example.susintegrado.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class card_ubs : AppCompatActivity() {
    private lateinit var binding: ActivityCardUbsBinding
    private lateinit var dbRef: DatabaseReference

    private lateinit var etEmpNomeUbs: EditText
    private lateinit var btEmpInserir: Button
    private lateinit var btVerLista: Button

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardUbsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etEmpNomeUbs = findViewById(R.id.nome_ubs)
        btEmpInserir = findViewById(R.id.bt_inserir)
        btVerLista = findViewById(R.id.bt_ver_lista)

        dbRef = FirebaseDatabase.getInstance().getReference("Employees")

        btEmpInserir.setOnClickListener{
            saveEmployeeData()
        }
        btVerLista.setOnClickListener {
            val irLista = Intent(this, lista::class.java)
            startActivity(irLista)
        }
    }
    private fun saveEmployeeData (){
        val empNomeUbs = etEmpNomeUbs.text.toString()

        if (empNomeUbs.isEmpty()){
            etEmpNomeUbs.error = "Insira o nome da UBS"
        }
        val empId = dbRef.push().key!!
        val employee = EmployeeModel(empId, empNomeUbs)

        dbRef.child(empId).setValue(employee).addOnCompleteListener{
            Toast.makeText(this, "UBS inserida com sucesso", Toast.LENGTH_SHORT).show()
            etEmpNomeUbs.text.clear()
        }.addOnFailureListener{ err ->
            Toast.makeText(this, "Erro ${err.message}", Toast.LENGTH_SHORT).show()
        }
    }

}