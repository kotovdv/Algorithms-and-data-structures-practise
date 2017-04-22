package com.kotovdv.algorithms.sorting.implementations

import com.kotovdv.algorithms.sorting.SortingAlgorithm
import com.kotovdv.algorithms.sorting.extensions.swap

/**
 * @author Dmitriy Kotov
 */
class BubbleSort : SortingAlgorithm {
    override fun sort(array: Array<Int>) {
        for (i in 1 until array.size) {
            var hadNoSwaps = true
            for (j in 0 until array.size - i) {
                if (array[j] > array[j + 1]) {
                    array.swap(j, j + 1)
                    hadNoSwaps = false
                }
            }

            if (hadNoSwaps) {
                break
            }
        }
    }
}