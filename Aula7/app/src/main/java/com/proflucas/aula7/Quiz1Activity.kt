package com.proflucas.aula7

import android.R.attr.button
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log.v
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.proflucas.aula7.ui.theme.Resultado

class Quiz1Activity : AppCompatActivity() {
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

        val resposta1: Button = findViewById(R.id.p1o1)
        val resposta2: Button = findViewById(R.id.p2o3)
        val resposta3: Button = findViewById(R.id.p3o4)
        val resposta4: Button = findViewById(R.id.p4o2)
        val resposta5: Button = findViewById(R.id.p5o2)

        val simpleArray = arrayOf(resposta1, resposta2, resposta3, resposta4, resposta5)

        for (btn in simpleArray) {
            btn.setOnClickListener {
                edtacertos += 1
                btn.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
            }
        }

        val fim = findViewById<Button>(R.id.btnResultados)
        fim.setOnClickListener {
            val acertos = edtacertos

            val intent = Intent(this, Resultado::class.java)
            intent.putExtra(Extras.CHAVE_ACERTOS, acertos)
            startActivity(intent)
            }
    }
}