package com.custommon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustommonApplication

fun main(args: Array<String>) {
	runApplication<CustommonApplication>(*args)
}
