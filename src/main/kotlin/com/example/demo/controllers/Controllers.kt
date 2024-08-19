package com.example.demo.controllers

import com.example.demo.models.Lenguaje
import com.example.demo.services.LenguajesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class Controlers{

    lateinit var lenguajesService: LenguajesService

    @Autowired
    constructor(lenguajesService: LenguajesService){
        this.lenguajesService = lenguajesService
    }

    @GetMapping("/")
    fun holaMundo(): String {
        return "Hola mundo"
    }

    @GetMapping("/Lenguaje")
    fun leerLenguajes(): List<Lenguaje> {
        return lenguajesService.getAllLenguajes()
    }

    @PostMapping("/Lenguaje")
    fun crearLenguajes(
        @RequestBody nuevoLenguaje: Lenguaje
    ):String {
        return lenguajesService.crearLenguahe(nuevoLenguaje)
    }

    @PutMapping("/Lenguaje/{id}")
    fun editarLenguaje(
        @PathVariable id: Int,
        @RequestBody lenguajeActualizado: Lenguaje
    ):String {
        return lenguajesService.actualizarLenguaje(id,lenguajeActualizado)
    }

    @DeleteMapping("Lenguaje/{id}")
    fun eliminarLenguaje(@PathVariable id: Int ): String {
        return lenguajesService.eliminarLenguaje(id)
    }

}
