package com.kotovdv.algorithms.various.arithmetic.expresion

import com.kotovdv.algorithms.various.exception.arithmetic.expression.NoOperatorFoundException
import java.math.BigDecimal

/**
 * @author Dmitriy Kotov
 */
enum class ArithmeticOperator(val representation: String) {
    PLUS("+") {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).plus(BigDecimal(rightOperand)).toString()
        }
    },
    MINUS("-") {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).minus(BigDecimal(rightOperand)).toString()
        }
    },
    MULTIPLY("*") {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).multiply(BigDecimal(rightOperand)).toString()
        }
    },
    DIVIDE("/") {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).divide(BigDecimal(rightOperand)).toString()
        }
    };

    abstract fun apply(leftOperand: String, rightOperand: String): String

    companion object {
        fun find(representation: String): ArithmeticOperator? {
            values().filter { it.representation == representation }
                    .forEach { return it }

            return null
        }

        fun get(representation: String): ArithmeticOperator {
            return find(representation) ?: throw NoOperatorFoundException(representation)
        }
    }
}