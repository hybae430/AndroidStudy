package com.example.kotlintest

// object: Singleton Pattern -> 딱 한 번 객체가 생성됨
// java에서는 boilerplate 필요하지만 Kotlin은 object 사용하면 된다!
object CarFactory {
    val cars = mutableListOf<Car>()

    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}