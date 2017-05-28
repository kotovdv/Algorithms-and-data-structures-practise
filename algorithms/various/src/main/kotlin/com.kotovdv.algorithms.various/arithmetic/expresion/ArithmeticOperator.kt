package com.kotovdv.algorithms.various.arithmetic.expresion

import com.kotovdv.algorithms.various.exception.arithmetic.expression.NoOperatorFoundException
import java.math.BigDecimal

/**
 * @author Dmitriy Kotov
 */
enum class ArithmeticOperator(val representation: String, val precedence: Int) {
    PLUS("+", 0) {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).plus(BigDecimal(rightOperand)).toString()
        }
    },
    MINUS("-", 0) {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).minus(BigDecimal(rightOperand)).toString()
        }
    },
    MULTIPLY("*", 1) {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).multiply(BigDecimal(rightOperand)).toString()
        }
    },
    DIVIDE("/", 1) {
        override fun apply(leftOperand: String, rightOperand: String): String {
            return BigDecimal(leftOperand).divide(BigDecimal(rightOperand)).toString()
        }
    };

    abstract fun apply(leftOperand: String, rightOperand: String): String

    companion object {
        fun isArithmeticOperator(representation: String): Boolean {
            return find(representation) != null
        }

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