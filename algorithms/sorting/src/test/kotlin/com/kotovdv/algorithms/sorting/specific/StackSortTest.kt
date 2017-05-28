package com.kotovdv.algorithms.sorting.specific

import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*
import java.util.function.Supplier

@RunWith(DataProviderRunner::class)
class StackSortTest {
    companion object {
        @JvmStatic
        @DataProvider
        fun positiveScenarios(): Array<Array<out Any>> {
            return arrayOf(
                    arrayOf(Supplier { LinkedList<Int>(listOf(5, 4, 3, 2, 1)) }, LinkedList<Int>(listOf(1, 2, 3, 4, 5))),
                    arrayOf(Supplier { LinkedList<Int>(listOf()) }, LinkedList<Int>(listOf())),
                    arrayOf(Supplier { LinkedList<Int>(listOf(1)) }, LinkedList<Int>(listOf(1)))
            )
        }
    }

    private val stackSort = StackSort()

    @Test
    @UseDataProvider("positiveScenarios")
    fun testSorting(inputListSupplier: Supplier<Deque<Int>>, expectedStack: Deque<Int>) {
        val inputStack = inputListSupplier.get()
        stackSort.sort(inputStack)
        assertThat(inputStack).isEqualTo(expectedStack)
    }
}