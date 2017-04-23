package com.kotovdv.algorithms.sorting.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ArrayExtensionsTest {

    @Test
    fun moveElementToClosestLeftTest() {
        val array = arrayOf(5, 4, 3, 2, 1)
        array.moveElement(from = 1, to = 0)

        assertThat(array).isEqualTo(arrayOf(4, 5, 3, 2, 1))
    }

    @Test
    fun moveElementToLeftTest() {
        val array = arrayOf(5, 4, 3, 2, 1)
        array.moveElement(from = 4, to = 0)

        assertThat(array).isEqualTo(arrayOf(1, 5, 4, 3, 2))
    }

    @Test
    fun moveElementToClosestRightTest() {
        val array = arrayOf(5, 4, 3, 2, 1)
        array.moveElement(from = 1, to = 2)

        assertThat(array).isEqualTo(arrayOf(5, 3, 4, 2, 1))
    }

    @Test
    fun moveElementToRightTest() {
        val array = arrayOf(5, 4, 3, 2, 1)
        array.moveElement(from = 1, to = 4)

        assertThat(array).isEqualTo(arrayOf(5, 3, 2, 1, 4))
    }

    @Test
    fun swapTest() {
        val array = arrayOf(0, 1)
        array.swap(leftIndex = 0, rightIndex = 1)

        assertThat(array).isEqualTo(arrayOf(1, 0))
    }
}