package com.example.demo.delete

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MobilePhoneTest {
    @Test
    fun addNewContact() {
        val mobilePhone = MobilePhone("123")
        val contact =  Contact("Bob", "123")

        mobilePhone.addNewContact(contact)

        assertTrue {
            mobilePhone.findContact(contact) != -1
        }
    }

    @Test
    fun removeContact() {
        val mobilePhone = MobilePhone("123")
        val contact = Contact("Bob", "123")

        mobilePhone.addNewContact(contact)

        assertTrue {
            mobilePhone.removeContact(contact)
        }
    }
}