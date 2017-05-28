package com.kotovdv.algorithms.various.arithmetic.expresion

import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Dmitriy Kotov
 */
@RunWith(DataProviderRunner::class)
class InfixToPostfixNotationTransformerTest {
    companion object {
        @JvmStatic
        @DataProvider
        fun positiveScenarios(): Array<Array<out Any>> {
            return arrayOf(
                    arrayOf(listOf("1", "+", "1"), listOf("1", "1", "+")),
                    arrayOf(listOf("1", "+", "1", "*", "2"), listOf("1", "1", "2", "*", "+")),
                    arrayOf(listOf("2", "*", "2", "+", "2", "*", "2"), listOf("2", "2", "*", "2", "2", "*", "+")),
                    arrayOf(listOf("(", "1", "+", "2", ")", "*", "3"), listOf("1", "2", "+", "3", "*")),
                    arrayOf(listOf("(", "(", "1", "+", "1", ")", "*", "2", "+", "(", "2", "*", "3", ")", ")", "*", "4"),
                            listOf("1", "1", "+", "2", "*", "2", "3", "*", "+", "4", "*"))
            )
        }
    }

    private val transformer = InfixToPostfixNotationTransformer()

    @Test
    @UseDataProvider("positiveScenarios")
    fun testTransformation(input: Iterable<String>, output: Iterable<String>) {
        assertThat(transformer.transform(input)).isEqualTo(output)
    }
}