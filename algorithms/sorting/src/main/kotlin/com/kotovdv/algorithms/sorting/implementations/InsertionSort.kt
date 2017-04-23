package com.kotovdv.algorithms.sorting.implementations

import com.kotovdv.algorithms.sorting.SortingAlgorithm

class InsertionSort : SortingAlgorithm {
    override fun sort(array: Array<Int>) {
        for (j in 1 until array.size) {
            val key = array[j]
            var i = j - 1

            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i]
                i--
            }

            array[i + 1] = key
        }
    }
}