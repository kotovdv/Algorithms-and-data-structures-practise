package com.kotovdv.algorithms.sorting.specific

import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(DataProviderRunner::class)
class KWayMergeTest {

    companion object {
        @JvmStatic
        @DataProvider
        fun scenarios(): Array<Array<out Any>> {
            return arrayOf(
                    arrayOf(listOf(arrayOf(1, 3), arrayOf(2, 4, 6), arrayOf(0, 5, 7)), arrayOf(0, 1, 2, 3, 4, 5, 6, 7)),
                    arrayOf(listOf(arrayOf<Int>(), arrayOf<Int>(), arrayOf<Int>()), arrayOf<Int>()))
        }
    }

    @Test
    @UseDataProvider("scenarios")
    fun testMerge(inputs: List<Array<Int>>, expectedOutput: Array<Int>) {
        val actualOutput = KWayMerge().merge(inputs)

        assertThat(actualOutput).isEqualTo(expectedOutput)
    }
}