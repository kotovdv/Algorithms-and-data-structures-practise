package com.kotovdv.algorithms.various.string.reverse

import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(DataProviderRunner::class)
class CharArrayReversalTest {

    companion object Scenarios {
        @DataProvider
        @JvmStatic
        fun scenarios(): Array<Array<out Any>> {
            return arrayOf(
                    arrayOf(charArrayOf('*'), charArrayOf('*')),
                    arrayOf(charArrayOf('a', '*'), charArrayOf('a', '*')),
                    arrayOf(charArrayOf('a', 'b', '*'), charArrayOf('b', 'a', '*')),
                    arrayOf(charArrayOf('a', 'b', 'c', '*'), charArrayOf('c', 'b', 'a', '*')),
                    arrayOf(charArrayOf('a', 'b', 'c', 'd', '*'), charArrayOf('d', 'c', 'b', 'a', '*')),
                    arrayOf(charArrayOf('a', 'b', 'c', 'd', 'e', '*'), charArrayOf('e', 'd', 'c', 'b', 'a', '*'))
            )
        }
    }

    val reversal = CharArrayReversal()


    @Test
    @UseDataProvider("scenarios")
    fun testStringReverse(input: CharArray, expectedState: CharArray) {
        reversal.reverse(input)
        assertThat(input).isEqualTo(expectedState)
    }

}