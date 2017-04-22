package com.kotovdv.algorithms.sorting.implementations.common

import java.util.function.Supplier


val sortingScenarios: Collection<SortingScenario> = arrayListOf(
        SortingScenario(before = Supplier { arrayOf(5, 4, 3, 2, 1) }, after = arrayOf(1, 2, 3, 4, 5)),
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