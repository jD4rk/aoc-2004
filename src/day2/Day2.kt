package day2

import println
import readFile


fun part1(lines: List<String>): Int {
    val evaluation = lines.map { line ->
        isLineSave(line.split(" ").map { it.toInt() })
    }

    return evaluation.count { it }
}


fun part2(lines: List<String>): Int {
    val evaluation = lines.map { line ->
        val listOfInt = line.split(" ").map { it.toInt() }
        if (isLineSave(listOfInt)) true
        else
            listIsDampener(listOfInt)
    }
    return evaluation.count { it }
}

fun listIsDampener(input: List<Int>): Boolean {
    val dampResult = input.indices.map {
        val shortList = input.toMutableList().apply { removeAt(it) }
        isLineSave(shortList)
    }

    return dampResult.any { it }
}

fun isLineSave(line: List<Int>): Boolean {
    val pairs = line.zipWithNext()

    val areAllIncreasing = pairs.all { (a, b) -> (b - a) in 1 .. 3  }
    val areAllDecreasing = pairs.all { (a, b) -> (b - a) in -3 .. -1  }

    return areAllIncreasing || areAllDecreasing
}


fun main() {
    val lines = readFile("day2/input.txt")

    val resultA = part1(lines)
    resultA.println()

    val resultB = part2(lines)
    resultB.println()
}
