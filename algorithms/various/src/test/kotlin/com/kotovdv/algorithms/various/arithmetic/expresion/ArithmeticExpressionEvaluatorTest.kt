package com.kotovdv.algorithms.various.arithmetic.expresion

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

    companion object Scenarios {
        @DataProvider
        @JvmStatic
        fun scenarios(): Array<Array<Any>> {
            return arrayOf(
                    arrayOf("1 + 1", BigDecimal(2)),
                    arrayOf("1+1", BigDecimal(2)),
                    arrayOf("1 - 1", BigDecimal(0)),
                    arrayOf("1-1", BigDecimal(0)),
                    arrayOf("2 * 2", BigDecimal(4)),
                    arrayOf("2 / 2", BigDecimal(1)),
                    arrayOf("1 + 1 * 2", BigDecimal(3)),
                    arrayOf("2 * 2 + 2 * 2", BigDecimal(8)),
                    arrayOf("2*2+2*2", BigDecimal(8))
            )
        }
    }

    private val evaluator = ArithmeticExpressionEvaluator()

    @Test
    @UseDataProvider("scenarios")
    fun evaluate(expression: String, result: BigDecimal) {
        assertThat(evaluator.evaluate(expression)).isEqualTo(result)
    }
}