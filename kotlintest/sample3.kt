package com.example.kotlintest

// private property나 method를 읽어올 수 있게 함 : java의 static 대신 사용
class Book(val id : Int, val name : String) {
    companion object BookFactory : IDProvider {
        override fun getId(): Int {
            return 444
        }
        val myBook = "new book"
        fun create() = Book(getId(), myBook)
    }
}

interface IDProvider {
    fun getId() : Int
}

fun main() {
    val book = Book.create()        // Book.BookFactory.create()와 동일 BookFactory 생략가능
                                    // companion object 이름을 정하지 않을 경우에는 Book.companion.~
    val bookId = Book.BookFactory.getId()
    println("${bookId} ${book.name}")
}