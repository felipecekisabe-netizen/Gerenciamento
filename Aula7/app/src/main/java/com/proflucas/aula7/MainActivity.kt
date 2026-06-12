package com.proflucas.aula7

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.google.firebase.Firebase
import com.google.firebase.database.*

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val quizUm=findViewById<Button>(R.id.BtnQuizOne)
        quizUm.setOnClickListener{
            setContentView(R.layout.activity_quiz1);
        }

        val quizDois=findViewById<Button>(R.id.BtnQuizDois)
        quizDois.setOnClickListener{
            setContentView(R.layout.activity_quiz2);
        }

        val placar=findViewById<Button>(R.id.BtnPlacar)
        placar.setOnClickListener{
            setContentView(R.layout.activity_placar);
        }
    }
}
