package com.kotovdv.algorithms.various.arithmetic.expresion

import java.util.*

/**
 * Shunting-yard algorithm implementation
 * Transforms infix notation expression to postfix notation expression (a.k.a. Reverse Polish Notation (RPN))
 *
 * @author Dmitriy Kotov
 */
class InfixToPostfixNotationTransformer {

    private val operatorsPrecedence: Map<String, Int> = hashMapOf(
            Operator.PLUS.representation to 0,
            Operator.MINUS.representation to 0,
            Operator.MULTIPLY.representation to 1,
            Operator.DIVIDE.representation to 1
    )

    fun transform(tokens: Iterable<String>): Iterable<String> {
        val outputQueue: Queue<String> = LinkedList<String>()
        val operatorsStack: Deque<String> = LinkedList<String>()
        for (token in tokens) {
            if (isOperator(token)) {
                handleOperator(token, operatorsStack, outputQueue)
            } else {
                handleNumber(token, outputQueue)
            }
        }

        outputQueue.addAll(operatorsStack)
        return outputQueue
    }

    private fun handleOperator(token: String, operatorsStack: Deque<String>, outputQueue: Queue<String>) {
        val stackOperator = operatorsStack.peekFirst()
        if (stackOperator != null) {
            if (isStackOperatorMorePrioritized(stackOperator, token)) {
                outputQueue.offer(operatorsStack.pop())
            }
        }

        operatorsStack.push(token)
    }

    private fun handleNumber(token: String, outputQueue: Queue<String>) {
        outputQueue.offer(token)
    }

    private fun isOperator(token: String): Boolean {
        return operatorsPrecedence.containsKey(token)
    }

    private fun isStackOperatorMorePrioritized(stackOperator: String, token: String): Boolean {
        return operatorsPrecedence[stackOperator]!! > operatorsPrecedence[token]!!
    }
}