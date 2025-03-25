package com.custommon

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/custommon")
class CustommonController(
    private val custommonService: CustommonService,
) {
    @GetMapping
    fun getAllCustommons(): ResponseEntity<List<Custommon>> {
        val custommons = custommonService.getAllCustommons()
        return ResponseEntity.ok(custommons)
    }

    @GetMapping("/{custommonId}")
    fun getCustommonById(@PathVariable("custommonId") custommonId: Int): ResponseEntity<Custommon> {
        val custommon = custommonService.getCustommonById(custommonId)
        return custommon.map { ResponseEntity.ok(it) }.orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping
    fun createCustommon(@RequestBody custommon: Custommon): ResponseEntity<Custommon> {
        val savedCustommon = custommonService.addCustommon(custommon)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustommon)
    }

    @DeleteMapping("/{custommonId}")
    fun deleteCustommon(@PathVariable("custommonId") custommonId: Int): ResponseEntity<Unit> {
        val gotRemoved = custommonService.removeCustommonById(custommonId)
        if (gotRemoved) return ResponseEntity.noContent().build()
        return ResponseEntity.notFound().build()
    }
}