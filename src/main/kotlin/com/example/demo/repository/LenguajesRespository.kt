package com.example.demo.repository

import com.example.demo.models.Lenguaje
import org.springframework.data.repository.CrudRepository

interface LenguajesRepository: CrudRepository<Lenguaje, Int>