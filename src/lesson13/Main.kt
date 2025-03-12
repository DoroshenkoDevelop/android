package lesson13

import java.util.concurrent.locks.Condition
import java.util.stream.Collectors

fun main() {
  /*  val action = { a : Int, b: Int -> a + b }
    val action2 : (Int, Int) -> Int = { a, b -> a + b }
    val action3 : (Unit) -> Unit = { println("Hello") }
    println(action.invoke(1,2))
    action(2,3)
    action3.invoke(Unit)
    val rez = operate(2,2) { a, b -> a + b }
    println(rez)*/
    letUse()
    letName()
    bookRun()
    newMap()
    newFilter()
    newSequence()
    newSequenceOf()

    val result = newInline(2, 9) { x, y -> x + y } // Передаём лямбду
    println(result)
    val text = "Hello"
    val vowelCount = text.countVowels()
    println(vowelCount)

    val numbers = listOf(1, 2, null, 4, 5)
    val average = numbers.average()
    println(average)

    val number1 = 4
    val number2 = 7
    println("$number1 true? ${number1.isEven()}")
    println("$number2 false? ${number2.isEven()}")
    createNumbers()
}

fun operate(a: Int, b: Int, aperation: (Int, Int) -> Int): Int {
    return aperation(a, b)
}

private fun letUse() {
    var name : String? = null
    name?.let {
        println("not null")
    }
    println( name?.let { it } ?: "")
}

private fun printText(text: String) {
    println(text)
}

private fun mapColl() {
    val array = mutableListOf(1,2,3,4)
    val rez = array.map {
        if (it <= 1){
            it
        }else{
            it * it
        }
    }
    println(rez)
}


/*Задача 1:Создайте объект класса Person с полем name, используя apply.
Затем выведите имя через let.*/

class Person {
    var name: String = "Pasha";
}
private fun letName() {
    var person = Person().apply {
        name.let { println(it) }
    }
}

/*Задача 2:Напишите код, который создает объект класса Book и выводит
информацию о нем, используя run*/

class Book {
    var books: String = "Harry Potter"
}
private fun bookRun() {
    var book = Book().run {
        println(books)
    }
}

fun stringSquare() {
    val result = listOf("First", "Second").map { it.toInt() * it.toInt()}
    println(result)
}

/*Задача 3:Напишите код, который создает объект класса Book и выводит
информацию о нем, используя run*/ // не доделано

private fun newMap() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val squaredNum = numbers.map { number ->
        (number * number).toString()
    }
    println(squaredNum)
}

/*Задача 4: Используя filter, создайте новый список, содержащий только четные
числа из исходного списка.*/

private fun newFilter() {
    val num = listOf(1,110,309,3)
    val newNum = num.filter {
        it % 2 == 0
    }
    println(newNum)
}

/*Задача 5: Используя asSequence, выполните последовательную фильтрацию и
возведение в квадрат для списка четных чисел, но только после того как вы
преобразуете его в Sequence.*/

private fun newSequence() {
    val sequence = listOf(1,43,65)
    val newSq = sequence.asSequence().filter { it % 2 == 0}.map { it * it }.toList()
    println(newSq)
}

/*Задача 6: Используя sequenceOf, создайте последовательность, содержащую
квадратные числа от 1 до 5*/

private fun newSequenceOf() {
    val newSequenceOf = sequenceOf(1,2,3,4,5).map { it * it }
    println(newSequenceOf.toList())
}

/*Задача 7: Создайте функцию inline, которая принимает два числа и выполняет
операцию сложения через лямбду*/

private fun newInline(first: Int, second: Int, operation: (Int,Int) -> Int): Int {
    return operation(first,second)
}


/*Задача 8: Создайте расширение для типа String, которое возвращает
количество гласных в строке.*/

private fun String.countVowels(): Int {
    val vow = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return this.count { it in vow }
}


/*Задача 9: Напишите расширение для List<Int>, которое возвращает среднее
значение.*/

private fun List<Int?>.average(): Double {
    val nonNullList = this.filterNotNull()
    if (nonNullList.isEmpty()) return 0.0
    return nonNullList.sum().toDouble() / nonNullList.size
}

/*Задача 10: Напишите расширение для типа Int, которое возвращает true, если
число четное, и false, если нечетное.*/

private fun Int.isEven(): Boolean {
    return this % 2 == 0
}
/*homework*/

/*Задача 1: Напишите функцию, которая принимает список целых чисел и
возвращает их сумму. Используйте лямбду в качестве параметра для
определения операции. (Reduce)*/

private fun sumOfNumbers(numbers: List<Int>): Int {
    return numbers.reduce { acc, num -> acc + num }
}

private fun getSumOfNumbers() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val sum = sumOfNumbers(numbers)
    println(sum)
}

/*Задача 2: Напишите программу, которая получает список людей, фильтрует
только тех, кто старше 18 лет, затем сортирует их по возрасту в порядке
убывания и выводит на экран с помощью apply и let. (sortedByDescending)*/
data class PersonS(val name: String, val age: Int)
private fun peopleList(people: List<Int>) {
    // Список людей
    val people = listOf(
        PersonS("Павел", 10),
        PersonS("Андрей", 25),

    )
    people.filter { it.age > 18 }.sortedByDescending { it.age }.let{ it ->
        it.forEach { element ->
            println(element.name + " " + element.age)
        }
    }


}

private fun createNumbers() {
    val sum = (1..1_000_000).asSequence()
        .filter { it % 2 == 0 }
        .map { it.toLong() * it }
        .sum()
        println(sum)
}
/*homework*/


















