package com.proflucas.aula7.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.proflucas.aula7.Extras
import com.proflucas.aula7.Jogador
import com.proflucas.aula7.MainActivity
import com.proflucas.aula7.R

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // [START declare_database_ref]
        lateinit var database: DatabaseReference
        // [END declare_database_ref]

        fun initializeDbRef() {
            // [START initialize_database_ref]
            database = Firebase.database.reference
            // [END initialize_database_ref]
        }

        val anuncio = findViewById<TextView>(R.id.pontuacaotxt)
        val pontuacao = intent.getStringExtra(Extras.CHAVE_ACERTOS) ?: "Sem nome recebido"

        anuncio.text = "$pontuacao de 10"



        val edtNome = findViewById<EditText>(R.id.nomeResultado)
        val voltar = findViewById<Button>(R.id.BtnVoltarp)

        voltar.setOnClickListener {

            val nome = edtNome.text.toString().trim()

            if (nome.isEmpty()) {

                Toast.makeText(
                    this,
                    "Digite um nome antes de continuar",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val pontos = pontuacao.toIntOrNull()

            val jogador = Jogador(
                nome = nome,
                pontos = pontos
            )

            fun adicionarAoPlacar(nome: String, pontos: Int) {
                val user = Jogador(nome, pontos)

                database.child("users").child(nome).setValue(user)
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
