package days.one

import util.getDayInput
import kotlin.math.abs

fun main() {
    val input = getDayInput(1)

    val listOne: MutableList<Int> = mutableListOf()
    val listTwo: MutableList<Int> = mutableListOf()

    input.bufferedReader().lines().forEach {
        it.split(" ").apply {
            listOne.add(first().toInt())
            listTwo.add(last().toInt())
        }
    }

    listOne.sort()
    listTwo.sort()

    var distance = listOne.indices.map { abs(listOne[it] - listTwo[it]) }.sum()

    println("The distance between the two lists is $distance")

    val similarity = listTwo.groupingBy { it }
        .eachCount()
        .filter { it.key in listOne }
        .map { it.key*it.value }
        .sum()

    println("The actual similarity of the two lists is $similarity")
}