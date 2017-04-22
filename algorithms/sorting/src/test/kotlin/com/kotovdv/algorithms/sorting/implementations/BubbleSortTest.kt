package com.kotovdv.algorithms.sorting.implementations

import com.kotovdv.algorithms.sorting.implementations.common.SortingAlgorithmTest
import com.kotovdv.algorithms.sorting.implementations.common.SortingScenario
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * @author Dmitriy Kotov
 */

class BubbleSortTest(val scenario: SortingScenario) : SortingAlgorithmTest(BubbleSort()) {

    @Test
    fun sort() {
        assertThat(sort(scenario.before)).isEqualTo(scenario.after)
    }
}
