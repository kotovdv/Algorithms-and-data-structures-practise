package com.kotovdv.algorithms.sorting.extensions

/**
 * @author Dmitriy Kotov
 */

fun <T> Array<T>.swap(leftIndex: Int, rightIndex: Int) {
    val temp = this[leftIndex]
    this[leftIndex] = this[rightIndex]
    this[rightIndex] = temp
}