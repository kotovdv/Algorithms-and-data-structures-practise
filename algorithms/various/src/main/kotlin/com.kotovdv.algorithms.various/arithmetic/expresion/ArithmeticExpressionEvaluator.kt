package com.kotovdv.algorithms.various.arithmetic.expresion

import java.math.BigDecimal
import java.util.*

/**
 * @author Dmitriy Kotov
 */

class ArithmeticExpressionEvaluator {

    private val infixToPostfixTransformer = InfixToPostfixNotationTransformer()

    fun evaluate(expression: String): BigDecimal {
        val tokens = expression.split(regex = Regex("\\s+"))
        val postfixNotationExpression: Iterable<String> = infixToPostfixTransformer.transform(tokens)

        return BigDecimal(calculate(postfixNotationExpression))
    }

    private fun calculate(postfixNotationExpression: Iterable<String>): String {
        val stack: Deque<String> = LinkedList<String>()

        for (token in postfixNotationExpression) {
            val operator = Operator.find(token)
            if (operator != null) {
                val rightOperand = stack.pop()
                val leftOperand = stack.pop()

                val resultingValue = operator.apply(leftOperand, rightOperand)
                stack.push(resultingValue)
            } else {
                stack.push(token)
            }
        }

        return stack.pop()
    }
}