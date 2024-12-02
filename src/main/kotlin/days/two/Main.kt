package days.two

import util.getDayInput

fun main() {
    val input = getDayInput(2)

    val reports = input.bufferedReader().lines().map { line -> line.split(" ").map { it.toInt() }.toList() }.toList()

    val safeReports = reports.map { it.zipWithNext { a, b -> b - a } }
        .filter { dif -> (dif.all { it in -3..-1 } || dif.all { it in 1..3 }) }

    println("There are ${safeReports.count()} safe reports")

    val updatedReports = reports.filter { report ->
        report.indices.any { skippedIndex ->
            val filtered = report.filterIndexed { i, _ -> i != skippedIndex }.zipWithNext { a, b -> b - a }
            filtered.all { it in -3..-1 } || filtered.all { it in 1..3 }
        }
    }

    println("There are ${updatedReports.count()} safe reports with the updated system")

}