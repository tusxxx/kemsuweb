package com.example.demo.delete

import kotlinx.serialization.Serializable
import kotlin.random.Random

class MobilePhone(myNumber: String) {
    private val myContacts = mutableListOf(Contact("Ignat Mustafaev", myNumber))

    fun addNewContact(newContact: Contact) = myContacts.add(newContact)

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val isUpdated = myContacts.removeIf {
            it == oldContact
        }
        if (isUpdated) myContacts.add(newContact)
        return isUpdated
    }

    fun updateContact(newContact: Contact) {
        myContacts.replaceAll {
            if (it.id == newContact.id) newContact else it
        }
    }

    fun removeContact(contact: Contact) = myContacts.remove(contact)

    fun findContact(contact: Contact): Int = myContacts.indexOf(contact)

    fun queryContact(query: String): Contact? = myContacts.firstOrNull { it.name == query }

    fun printContacts() = myContacts.forEach(::println)
}

@Serializable
data class Contact(val name: String, val number: String, val id: Int = Random.nextInt())
