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
class PostfixNotationExpressionCalculatorTest {
    companion object {
        @JvmStatic
        @DataProvider
        fun positiveScenarios(): Array<Array<out Any>> {
            return arrayOf(
                    arrayOf(listOf("1", "1", "+"), "2"),
                    arrayOf(listOf("1", "1", "2", "*", "+"), "3"),
                    arrayOf(listOf("2", "2", "*", "2", "2", "*", "+"), "8"),
                    arrayOf(listOf("1", "2", "+", "3", "*"), "9"),
                    arrayOf(listOf("1", "1", "+", "2", "*", "2", "3", "*", "+", "4", "*"), "40")
            )
        }
    }

    private val calculator = PostfixNotationExpressionCalculator()

    @Test
    @UseDataProvider("positiveScenarios")
    fun testPostfixNotationCalculation(postfixNotation: Iterable<String>, expectedResult: String) {
        assertThat(calculator.calculate(postfixNotation)).isEqualTo(expectedResult)
    }
}