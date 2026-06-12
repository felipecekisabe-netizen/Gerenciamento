package com.proflucas.aula7

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties

data class Jogador (
    val nome: String? = null,
    val pontos: Int? = null
)
