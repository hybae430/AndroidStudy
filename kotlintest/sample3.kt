package com.example.kotlintest

// java의 static 대신 사용 (정적 메소드..)
class Book(val id : Int, val name : String) {
    companion object {
        fun create() = Book(0, "animal farm")
    }
}

fun main() {
    val book = Book.Companion.create()      // companion 생략가능
    println("${book.id} ${book.name}")
}