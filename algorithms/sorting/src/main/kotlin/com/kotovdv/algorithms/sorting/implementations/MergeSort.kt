package com.kotovdv.algorithms.sorting.implementations

import com.kotovdv.algorithms.sorting.SortingAlgorithm
import com.kotovdv.algorithms.sorting.extensions.split

class MergeSort : SortingAlgorithm {
    override fun sort(array: Array<Int>) {
        System.arraycopy(doSort(array), 0, array, 0, array.size)
    }

    private fun doSort(array: Array<Int>): Array<Int> {
        if (array.size <= 1) {
            return array
        }

        var (leftPart, rightPart) = array.split(array.size / 2)
        leftPart = doSort(leftPart)
        rightPart = doSort(rightPart)

        return merge(leftPart, rightPart)
    }

    private fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
        val size = left.size + right.size
        val mergedArray = arrayOfNulls<Int>(size)

        var leftIndex = 0
        var rightIndex = 0
        for (i in 0 until size) {
            if (leftIndex == left.size) {
                mergedArray[i] = right[rightIndex]
                rightIndex++
            } else if (rightIndex == right.size) {
                mergedArray[i] = left[leftIndex]
                leftIndex++
            } else if (left[leftIndex] < right[rightIndex]) {
                mergedArray[i] = left[leftIndex]
                leftIndex++
            } else {
                mergedArray[i] = right[rightIndex]
                rightIndex++
            }
        }

        return mergedArray.requireNoNulls()
    }
}