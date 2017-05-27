package com.kotovdv.algorithms.various.arithmetic.expresion

import java.util.*

/**
 * @author Dmitriy Kotov
 */
class PostfixNotationExpressionCalculator {

    fun calculate(postfixNotationExpression: Iterable<String>): String {
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