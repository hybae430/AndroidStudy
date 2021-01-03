package com.example.kotlintest

/*
* Java와 다른 점:
* 1. 꼭 파일명과 class명이 같지 않아도 됨
* 2. 한 파일에 여러 개의 class가 들어있을 수 있음
* */

open class Human(val name: String = "Anonymous") {   // constructor(name : String)에서 constructor 생략가능
                                                // default 값은 String = "Anonymous"로 설정가능
                                                // 인자로 받은 값을 바로 할당하기 위해 val name으로 설정

    constructor(name : String, age : Int) : this(name) {
        println("my name is ${name}, ${age} years old")
    }                                           // 부생성자(오버로딩): init보다 늦게 실행

    init {                                      // 객체가 처음 생성될 때 실행되는 함수(주생성자)
        println("new human has been born!!")
    }

    fun eatingCake() {
        println("This is so YUMMMYYY~~")
    }

    open fun singASong() {
        println("lalala")
    }
}

class Korean : Human() {                        // 모든 kotlin class는 final이기 때문에 상속하기 위해서
                                                // open class로 만들어야 함
                                                // 자바와 동일하게 한 개의 클래스만 상속받을 수 있음

    override fun singASong() {                  // override를 위해 함수도 open 필요
        super.singASong()                       // 기존 함수 사용
        println("랄랄라")                        // 새로운 기능 추가
        println("my name is: ${name}")
    }
}

fun main() {
    val human = Human("minsu")
    val stranger = Human()
    human.eatingCake()

    println("this human's name is ${human.name}")
    println("this human's name is ${stranger.name}")

    val mom = Human("JY", 57)

    val korean = Korean()
    korean.singASong()
}