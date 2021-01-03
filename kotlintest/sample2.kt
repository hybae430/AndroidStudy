package com.example.kotlintest

/*
* 1. Lambda
* 람다식은 우리가 마치 value처럼 다룰 수 있는 익명함수이다.
* 1) 메소드의 파라미터로 넘겨줄 수 있다.
* 2) return값으로 사용할 수 있다.
*
* 람다의 기본정의
* val lambdaName : Type = {argument -> codeBody}
* */

val square : (Int) -> (Int) = {number -> number * number}
                                                // 한 곳에는 타입 명시해주어야 함
val nameAge = {name : String, age : Int ->
    "my name is ${name}. I'm ${age}."
}

fun main() {
    println(square(12))
    println(nameAge("hayoung", 26))

    val a = "hayoung said "
    val b = "hb said "
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("hayoung", 26))

    println(calculateGrade(97))
    println(calculateGrade(971))

    val lambda = {number : Double ->
        number == 4.3213
    }
    println(invokeLambda(lambda))               // 위 lambda를 넣을 경우 5.2343과 같지 않으므로 false
    println(invokeLambda({it > 3.22}))          // 5.2343이 3.22보다 크므로 true
                                                // var lambda가 없어도 실행됨 (왜지..)
}

// 확장함수

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"}
                                                // 인자가 Int 하나뿐이면 it으로 생략 가능
    return name.introduceMyself(age)
}

// 람다의 Return

val calculateGrade : (Int) -> String = {        // input type은 여러 개가 있을 수 있으므로 () 필요
    when (it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법

fun invokeLambda(lambda : (Double) -> Boolean) : Boolean {
    return lambda(5.2343)
}