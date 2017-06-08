package com.kotovdv.algorithms.sorting.specific

import java.util.*

class KWayMerge {

    inline fun <reified T : Comparable<T>> merge(sortedInputs: List<Array<T>>): Array<T> {
        val heap = PriorityQueue <KWayMergeKey<T>>()

        sortedInputs.forEach {
            if (!it.isEmpty()) {
                heap.add(KWayMergeKey(it, 0))
            }
        }

        val resultingSize = sortedInputs.stream().mapToInt { array -> array.size }.sum()
        val mergedInput = arrayOfNulls<T>(resultingSize)
        var currentIndex = 0

        while (!heap.isEmpty()) {
            val minKey = heap.poll()

            mergedInput[currentIndex] = minKey.getValue()
            currentIndex++

            if ((minKey.index + 1) < minKey.associatedArray.size) {
                heap.add(KWayMergeKey(minKey.associatedArray, minKey.index + 1))
            }
        }

        return mergedInput.requireNoNulls()
    }
}