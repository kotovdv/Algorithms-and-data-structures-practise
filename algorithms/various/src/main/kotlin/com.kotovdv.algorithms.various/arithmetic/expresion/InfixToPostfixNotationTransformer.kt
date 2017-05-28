package com.kotovdv.algorithms.various.arithmetic.expresion

import com.kotovdv.algorithms.various.arithmetic.expresion.ArithmeticOperator.Companion.isArithmeticOperator
import com.kotovdv.algorithms.various.exception.arithmetic.expression.BracketsMismatchException
import java.util.*

/**
 * Shunting-yard algorithm implementation
 * Transforms infix notation expression to postfix notation expression (a.k.a. Reverse Polish Notation (RPN))
 *
 * @author Dmitriy Kotov
 */
class InfixToPostfixNotationTransformer {

    fun transform(tokens: Iterable<String>): Iterable<String> {
        val outputQueue: Queue<String> = LinkedList<String>()
        val operatorsStack: Deque<String> = LinkedList<String>()

        for (token in tokens) {
            if (isRoundBracket(token)) {
                handleRoundBracket(token, operatorsStack, outputQueue)
            } else if (isArithmeticOperator(token)) {
                handleOperator(token, operatorsStack, outputQueue)
            } else {
                handleNumber(token, outputQueue)
            }
        }
        flushOperators(operatorsStack, outputQueue)

        return outputQueue
    }

    private fun handleRoundBracket(token: String, operatorsStack: Deque<String>, outputQueue: Queue<String>) {
        if (token == "(") {
            operatorsStack.push(token)
        } else {
            while (operatorsStack.size > 0 && operatorsStack.peek() != "(") {
                val nextOperator = operatorsStack.pop()
                outputQueue.offer(nextOperator)
            }

            if (operatorsStack.size == 0) {
                throw BracketsMismatchException()
            }
            operatorsStack.pop()
        }
    }

    private fun handleOperator(token: String, operatorsStack: Deque<String>, outputQueue: Queue<String>) {
        val stackOperator = operatorsStack.peekFirst()
        if (stackOperator != null) {
            if (!isRoundBracket(stackOperator) && isStackOperatorMorePrioritized(stackOperator, token)) {
                outputQueue.offer(operatorsStack.pop())
            }
        }

        operatorsStack.push(token)
    }

    private fun handleNumber(token: String, outputQueue: Queue<String>) {
        outputQueue.offer(token)
    }

    private fun flushOperators(operatorsStack: Deque<String>, outputQueue: Queue<String>) {
        while (!operatorsStack.isEmpty()) {
            val nextOperator = operatorsStack.pop()
            if (isRoundBracket(nextOperator)) {
                throw BracketsMismatchException()
            }

            outputQueue.offer(nextOperator)
        }
    }

    private fun isRoundBracket(token: String): Boolean {
        return ")" == token || "(" == token
    }

    private fun isStackOperatorMorePrioritized(stackOperator: String, token: String): Boolean {
        return ArithmeticOperator.get(stackOperator).precedence > ArithmeticOperator.get(token).precedence
    }
}