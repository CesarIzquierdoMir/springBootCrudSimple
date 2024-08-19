package com.example.demo.services

import com.example.demo.models.Lenguaje
import com.example.demo.repository.LenguajesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LenguajesService {

    lateinit var lenguajesRepository: LenguajesRepository

    @Autowired
    constructor(lenguajesRepository: LenguajesRepository){
        this.lenguajesRepository = lenguajesRepository
    }

    fun getAllLenguajes(): List<Lenguaje>{
        return lenguajesRepository.findAll().toList()
    }

    fun crearLenguahe(nuevoLenguaje: Lenguaje): String {
        return lenguajesRepository.save(nuevoLenguaje).let {
            "Nuevo lenguaje creado  ID: ${it.id}"  }
    }

    fun actualizarLenguaje(id: Int, lenguajeActualizado: Lenguaje): String {
        return lenguajesRepository.findById(id).map { lenguajeExistente ->
            val lenguajeConCambios = lenguajeExistente.copy(
                nombre = lenguajeActualizado.nombre,
                lanzamiento = lenguajeActualizado.lanzamiento,
                tipado_fuerte = lenguajeActualizado.tipado_fuerte
            )
            lenguajesRepository.save(lenguajeConCambios)
            "Lenguaje con ID: $id actualizado exitosamente."
        }.orElse("Lenguaje con ID: $id no encontrado.")
    }

    fun eliminarLenguaje(id: Int): String {
        return if (lenguajesRepository.existsById(id)){
            lenguajesRepository.deleteById(id)
            "Lenguaje con ID: $id eliminado exitosamente."
        } else {
            "Lenguaje con ID: $id no encontrado."
        }
    }
}