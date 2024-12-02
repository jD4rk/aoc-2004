package day1

import println
import readFile
import kotlin.math.absoluteValue


fun part1(input: List<String>): Int {
    val (left, right) = input.map { single ->
        val first = single.substringBefore(" ").toLong()
        val second = single.substringAfterLast(" ").toLong()
        first to second
    }.unzip()

    return left.sorted().zip(right.sorted()).sumOf { (first, second) ->
        (first - second).absoluteValue
    }.toInt()
}

fun part2(input: List<String>): Int {
    val (left, right) = input.map { single ->
        val first = single.substringBefore(" ").toLong()
        val second = single.substringAfterLast(" ").toLong()
        first to second
    }.unzip()

    val reps = right.groupingBy { it }.eachCount()
    return left.sumOf { num ->
        num * (reps[num] ?: 0)
    }.toInt()
}

fun main() {

    val lines = readFile("day2/input.txt")

    val result1A = part1(lines)
    // Test if implementation meets criteria from the description, like:
    //check(result1A == 1)

    result1A.println()

    val lines2 = readFile("day2/input.txt")

    val result1B = part2(lines2)
    //check(result1B == 1)

    result1B.println()
}
