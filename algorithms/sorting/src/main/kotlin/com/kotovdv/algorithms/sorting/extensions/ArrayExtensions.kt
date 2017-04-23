package com.kotovdv.algorithms.sorting.extensions

import java.lang.System.arraycopy

/**
 * @author Dmitriy Kotov
 */
fun <T> Array<T>.swap(leftIndex: Int, rightIndex: Int) {
    val temp = this[leftIndex]
    this[leftIndex] = this[rightIndex]
    this[rightIndex] = temp
}

fun <T> Array<T>.moveElement(from: Int, to: Int) {
    val temp = this[from]

    arraycopy(this, from + 1, this, from, size - from - 1)
    arraycopy(this, to, this, to + 1, size - to - 1)

    this[to] = temp
}