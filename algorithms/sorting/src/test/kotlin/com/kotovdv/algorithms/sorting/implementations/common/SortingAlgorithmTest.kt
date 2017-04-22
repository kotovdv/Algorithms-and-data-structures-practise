package com.kotovdv.algorithms.sorting.implementations.common

import com.kotovdv.algorithms.sorting.SortingAlgorithm
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.function.Supplier

/**
 * @author Dmitriy Kotov
 */
@RunWith(Parameterized::class)
abstract class SortingAlgorithmTest(val sortingAlgorithm: SortingAlgorithm) {

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