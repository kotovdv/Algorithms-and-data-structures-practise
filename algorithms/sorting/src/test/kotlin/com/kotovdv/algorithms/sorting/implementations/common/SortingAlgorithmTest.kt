package com.kotovdv.algorithms.sorting.implementations.common

import com.kotovdv.algorithms.sorting.SortingAlgorithm
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*
import java.util.function.Supplier

/**
 * @author Dmitriy Kotov
 */
@RunWith(Parameterized::class)
abstract class SortingAlgorithmTest(val scenario: SortingScenario, val sortingAlgorithm: SortingAlgorithm) {

    @Test
    fun sortPredefinedScenarios() {
        assertThat(sort(scenario.before)).isEqualTo(scenario.after)
    }

    @Test
    fun sortRandomArray() {
        val randomArrays = randomArrays()

        for (array in randomArrays) {
            val initialArrayCopy = array.copyOf()
            assertThat(sortingAlgorithm.sort(array)).isEqualTo(Arrays.sort(initialArrayCopy))
        }
    }

    protected fun sort(arraySupplier: Supplier<Array<Int>>): Array<Int> {
        val array = arraySupplier.get()
        sortingAlgorithm.sort(array)

        return array
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Scenario : [{0}]")
        fun data(): Collection<SortingScenario> {
            return sortingScenarios
        }
    }
}