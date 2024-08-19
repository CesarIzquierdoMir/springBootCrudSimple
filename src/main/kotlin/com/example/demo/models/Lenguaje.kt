package com.example.demo.models

import jakarta.persistence.*
@Entity
data class Lenguaje(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name= "id")
        var id: Int?,

        val nombre: String,
        val lanzamiento: String,
        val tipado_fuerte: Int
        )
