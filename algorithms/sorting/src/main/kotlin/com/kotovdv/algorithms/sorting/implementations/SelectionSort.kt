package com.kotovdv.algorithms.sorting.implementations

import com.kotovdv.algorithms.sorting.SortingAlgorithm
import com.kotovdv.algorithms.sorting.extensions.swap

class SelectionSort : SortingAlgorithm {
    override fun sort(array: Array<Int>) {
        for (i in 0 until array.size) {
            var minIndex = i
            for (j in i until array.size) {
                if (array[minIndex] > array[j]) {
                    minIndex = j
                }
            }

            if (minIndex != i) {
                array.swap(i, minIndex)
            }
        }
    }
}