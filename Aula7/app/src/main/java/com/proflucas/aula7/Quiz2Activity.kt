package com.proflucas.aula7

import android.R.attr.button
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.proflucas.aula7.ui.theme.Resultado

class Quiz2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var edtacertos = 0

        val resposta1: Button = findViewById(R.id.p1o2)
        val resposta2: Button = findViewById(R.id.p2o1)
        val resposta3: Button = findViewById(R.id.p3o4)
        val resposta4: Button = findViewById(R.id.p4o2)
        val resposta5: Button = findViewById(R.id.p5o4)

        // Bloco de código lambda que executa a mesma ação
        val acaoCompartilhada: (View) -> Unit = { view ->
            val botaoApertado = view as Button
            edtacertos += 1
            botaoApertado.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#8bf0bc"))
        }

        resposta1.setOnClickListener(acaoCompartilhada)
        resposta2.setOnClickListener(acaoCompartilhada)
        resposta3.setOnClickListener(acaoCompartilhada)
        resposta4.setOnClickListener(acaoCompartilhada)
        resposta5.setOnClickListener(acaoCompartilhada)

        val fim = findViewById<Button>(R.id.btnResultados)
        fim.setOnClickListener {
            val acertos = edtacertos

            val intent = Intent(this, Resultado::class.java)
            intent.putExtra(Extras.CHAVE_ACERTOS, acertos)
            startActivity(intent)
        }
    }
}