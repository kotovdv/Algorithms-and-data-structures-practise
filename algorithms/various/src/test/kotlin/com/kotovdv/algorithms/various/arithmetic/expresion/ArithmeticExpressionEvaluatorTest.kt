package com.kotovdv.algorithms.various.arithmetic.expresion

import com.kotovdv.algorithms.various.exception.arithmetic.expression.BracketsMismatchException
import com.tngtech.java.junit.dataprovider.DataProvider
import com.tngtech.java.junit.dataprovider.DataProviderRunner
import com.tngtech.java.junit.dataprovider.UseDataProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal

/**
 * @author Dmitriy Kotov
 */
@RunWith(DataProviderRunner::class)
class ArithmeticExpressionEvaluatorTest {
    companion object {
        @JvmStatic
        @DataProvider
        fun positiveScenarios(): Array<Array<Any>> {
            return arrayOf(
                    arrayOf("1 + 1", BigDecimal(2)),
                    arrayOf("1+1", BigDecimal(2)),
                    arrayOf("1 - 1", BigDecimal(0)),
                    arrayOf("1-1", BigDecimal(0)),
                    arrayOf("2 * 2", BigDecimal(4)),
                    arrayOf("2 / 2", BigDecimal(1)),
                    arrayOf("1 + 1 * 2", BigDecimal(3)),
                    arrayOf("2 * 2 + 2 * 2", BigDecimal(8)),
                    arrayOf("2*2+2*2", BigDecimal(8)),
                    arrayOf("(1+2)*3", BigDecimal(9)),
                    arrayOf("1+(2*3)", BigDecimal(7)),
                    arrayOf("(1+(2*3))*4", BigDecimal(28)),
                    arrayOf("((1+1)*2+(2*3))*4", BigDecimal(40))
            )
        }

        @JvmStatic
        @DataProvider
        fun bracketsMismatch(): Array<Array<out Any>> {
            return arrayOf(
                    arrayOf("(1 + 1"),
                    arrayOf("1 + 1)"),
                    arrayOf("((1 + 1)"),
                    arrayOf("(((1 + 1)+5)")
            )
        }
    }

    private val evaluator = ArithmeticExpressionEvaluator()

    @Test
    @UseDataProvider("positiveScenarios")
    fun testEvaluation(expression: String, result: BigDecimal) {
        assertThat(evaluator.evaluate(expression)).isEqualTo(result)
    }


    @Test(expected = BracketsMismatchException::class)
    @UseDataProvider("bracketsMismatch")
    fun testBracketsMismatchEvaluation(expression: String) {
        evaluator.evaluate(expression)
    }
}