package com.kotovdv.algorithms.sorting.implementations.common

import java.util.concurrent.ThreadLocalRandom
import java.util.function.Supplier


val sortingScenarios: Collection<SortingScenario> = arrayListOf(
        SortingScenario(before = Supplier { arrayOf(5, 4, 3, 2, 1) }, after = arrayOf(1, 2, 3, 4, 5)),
        SortingScenario(before = Supplier { arrayOf(0) }, after = arrayOf(0)),
        SortingScenario(before = Supplier { arrayOf(0, 0, 0) }, after = arrayOf(0, 0, 0)),
        SortingScenario(before = Supplier { arrayOf(1, 0) }, after = arrayOf(0, 1)),
        SortingScenario(before = Supplier { arrayOf(0, 1) }, after = arrayOf(0, 1)),
        SortingScenario(before = Supplier { arrayOf(4, 3, 2, 1, 5) }, after = arrayOf(1, 2, 3, 4, 5)),
        SortingScenario(before = Supplier { arrayOf(1, 2, 3, 4, 5) }, after = arrayOf(1, 2, 3, 4, 5)),
        SortingScenario(before = Supplier { arrayOf(3, 2, 1, 1, 2, 3) }, after = arrayOf(1, 1, 2, 2, 3, 3)),
        SortingScenario(before = Supplier { emptyArray<Int>() }, after = emptyArray())
)

class SortingScenario(val before: Supplier<Array<Int>>, val after: Array<Int>) {
    override fun toString(): String {
        return "${before.get().contentToString()} -> ${after.contentToString()}"
    }
}


fun randomArrays(count: Int = 3): List<Array<Int>> {
    val arrays = mutableListOf<Array<Int>>()
    for (i in 1..count) {
        val size = random().nextInt(5, 10)
        val array = IntArray(size)

        for (j in 0 until array.size) {
            array[j] = random().nextInt(0, 99)
        }

        arrays.add(array.toTypedArray())
    }

    return arrays
}

private fun random() = ThreadLocalRandom.current()

