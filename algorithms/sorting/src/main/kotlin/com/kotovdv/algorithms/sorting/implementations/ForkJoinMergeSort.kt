package com.kotovdv.algorithms.sorting.implementations

import com.kotovdv.algorithms.sorting.SortingAlgorithm
import com.kotovdv.algorithms.sorting.extensions.split
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask

class ForkJoinMergeSort : MergeSort(), SortingAlgorithm {
    override fun sort(array: Array<Int>) {
        val sortedArray = ForkJoinPool().invoke(MergeSortTask(array))
        System.arraycopy(sortedArray, 0, array, 0, array.size)
    }

    private inner class MergeSortTask(var array: Array<Int>) : RecursiveTask<Array<Int>>() {
        override fun compute(): Array<Int> {
            if (array.size <= 1) {
                return array
            }

            val (leftPart, rightPart) = array.split(array.size / 2)
            val leftFork = MergeSortTask(leftPart).fork()
            val rightFork = MergeSortTask(rightPart).fork()

            return this@ForkJoinMergeSort.merge(leftFork.join(), rightFork.join())
        }
    }
}