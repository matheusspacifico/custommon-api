package com.custommon

import org.springframework.stereotype.Service
import java.util.*

@Service
class CustommonService(
    private val repository: CustommonRepository
) {
    fun getAllCustommons(): List<Custommon>? {
        return repository.findAll()
    }

    fun getCustommonById(custommonId: Int): Optional<Custommon> {
        return repository.findById(custommonId)
    }

    fun addCustommon(custommon: Custommon): Custommon? {
        val updatedCustommon = custommon.copy(weaknesses = Type.getWeaknesses(custommon.types))
        return repository.save(updatedCustommon)
    }

    fun removeCustommonById(custommonId: Int): Boolean {
        val exists = repository.existsById(custommonId)
        if (exists) {
            repository.deleteById(custommonId)
            return true
        }
        return false
    }
}