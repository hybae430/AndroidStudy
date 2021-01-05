package com.example.kotlintest

data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hashCode(), equals(), copy()
// kotlin은 이런 data class를 여러 개 한 파일에다 만들 수 있다. (자바 불가능)

class TicketNormal(val companyName: String, val name: String, var date: String, var seatNumber: Int)

fun main() {
    val ticketA = Ticket("koreanAir", "hayoungBae", "2021-01-05", 14)
    val ticketB = TicketNormal("koreanAir", "hayoungBae", "2021-01-05", 14)

    println(ticketA)            // 객체 내용
    println(ticketB)            // 메모리 주소값
}