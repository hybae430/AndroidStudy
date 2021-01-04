package com.example.kotlintest

fun main() {
    helloWorld()
    println(add(4, 5))

    // 3. String Template
    val name = "Hayoung"
    println("my name is ${name}.")  // $뒤 대괄호 안의 모든 것을 변수로 판단, 뒤에 공백을 줄 경우 생략가능
    println("is this true? ${1 == 0}")
                                    // 안에 boolean 식을 넣으면 그 결과값이 true/false로 나옴
    println("this is 2\$a")         // 그냥 $를 사용하고 싶은 경우 앞에 \ 붙이기

    checkNum(1)

    forAndWhile()

    nullcheck()

    ignoreNulls("not")
}

// 1. 함수

fun helloWorld() : Unit {           // Unit은 Java의 void와 같음 (return값이 없는 함수) + 생략가능
    println("Hello Kotlin World!")
}

fun add(a : Int, b : Int) : Int {   // Int 대문자 Int형으로 return하는 함수, 인자 타입 방식 기억
    return a + b
}

// 2. val vs. var
// val = value(상수), var = variable(변수)

fun hi() {
    val a : Int = 10
    var b : Int = 9
    b = 100                         // a는 reassign 가능, b는 불가능

    val c = 100
    var d = 100
    var name = "Hayoung"            // TypeCast 자동으로 하기 때문에 자료형 명시 안해도 됨

    var e : String                  // 값을 바로 할당하지 않을 경우에는 자료형 명시 반드시 해야 함
}

// 주석
// 한 줄 짜리 주석은 이렇게
/*
* 여러 줄
* 주석은
* 이렇게
* 달 수 있음 */
// Android Studio에서는 ctrl+/로 여러 줄 주석을 한꺼번에 넣고 취소할 수 있음

// 4. 조건식

fun maxBy(a : Int, b: Int) : Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxBy2(a : Int, b : Int) = if (a > b) a else b

fun checkNum(score : Int) {
    when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3")   // 복수 답안 가능
        else -> println("I don't know")     // when을 function과 사용했을 때 else 생략 가능
    }

    var b = when(score) {
        1 -> 1
        2 -> 2
        else -> 3                           // return 식으로 사용했을 때는 else가 필수
    }

    println("b : ${b}")

    when (score) {
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}

// Expression vs. Statement
/*
* 코틀린의 모든 함수는 expression(Unit이라도 return하기 때문)
* expression/statement는 값을 return하는지 여부에 따라 갈림*/

// 5. Array and List
// Array
// List 1. (Immutable)List(읽기전용) 2. Mutable List

fun array() {
    val array = arrayOf(1, 2, 3)            // 초기화
    val list = listOf(1, 2, 3)

    val array2 = arrayOf(1, "d", 3.4f)      // Type: Any
    val list2 = listOf(1, "d", 11L)

    array[0] = 3                            // array는 가능 (size만 같으면)
//    list[0] = 3                           // list는 immutable이라 값 변경 불가능
    var result = list.get(0)

    val arrayList = arrayListOf<Int>()      // mutable list의 한 종류
    arrayList.add(10)                       // list 내용 수정해도 참조값이 변하지 않음으로 val 사용가능
    arrayList.add(20)
}

// 6. For / While

fun forAndWhile() {
    val students = arrayListOf("hayoung", "hyungbin", "jaehwan", "kangjun")
    for (name in students) {
        println("${name}")
    }
    for ((index, name) in students.withIndex()) {
        println("${index + 1}번째 학생: ${name}")
    }

    var sum : Int = 0
    for (i in 1..10 step 2) {               // step a는 a씩 건너뛰는 것
                                            // a..b 는 1 이상 b 이하 (둘 다 포함)
        sum += i
    }
    println(sum)
    sum = 0
    for (i in 10 downTo 1) {                // a downTo b는 a에서 b까지 하나씩 작아지는 것 (b 포함)
        sum += i
    }
    println(sum)
    sum = 0
    for (i in 1 until 100) {                // a until b는 a에서 b-1까지 하나씩 커지는 것 (b 포함 x)
        sum += i
    }
    println(sum)

    var index = 0
    while (index < 10) {
        println("current index: ${index}")
        index++
    }
}

// 7. Nullable / NonNull

fun nullcheck() {
    // NPE: Null pointer Exception

    var name = "hayoung"                    // 자동으로 NonNull type
    var nullName : String? = null           // Nullable type
    var nameInUpperCase = name.toUpperCase()
    var nullNameInUpperCase = nullName?.toUpperCase()
                                            // nullName이 null인지 검사하고, 함수 실행 혹은 return null

    // ?:   엘비스 연산자
    val lastName : String? = null
    val fullName = name + " " + (lastName?: "NO lastName")
                                            // ?: null인 경우 default 값 줄 때 사용
    println(fullName)
}

// !!

fun ignoreNulls(str : String?) {
    val mNotNull : String = str!!           // str이 절대 null이 아니라고 컴파일러에게 전달하는 기능
    val upper = mNotNull.toUpperCase()

    val email : String? = "hayoungXXXX@naver.com"
    email?.let {
        println("my email is ${it}")
    }                                       // email이 null인 경우 내부 함수 실행 안됨. safe!
}