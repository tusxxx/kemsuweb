package com.example.demo.controllers

import com.example.demo.delete.Contact
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class EchoController {

	@GetMapping("/echo")
	fun echo(@RequestParam("q") q: String): String {
		return q
	}

	@GetMapping("/")
	fun helloWorld(): String {
		return "Hello World!"
	}

	@GetMapping("/serialized")
	fun serialized(): String {
		val contact = Contact("Bob", "123-456-7890")
		return Json.encodeToString(contact)
	}

	@GetMapping("/error500")
	fun error500(@RequestParam("name") name: String) {
		throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, name)
	}
}
