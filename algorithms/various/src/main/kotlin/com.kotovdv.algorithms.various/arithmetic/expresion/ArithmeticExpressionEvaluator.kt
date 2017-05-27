package com.kotovdv.algorithms.various.arithmetic.expresion

import java.math.BigDecimal

/**
 * @author Dmitriy Kotov
 */

class ArithmeticExpressionEvaluator {

    private val postfixNotationTransformer = InfixToPostfixNotationTransformer()
    private val postfixNotationCalculator = PostfixNotationExpressionCalculator()
    private val OPERATORS = "(" + Operator.values()
            .map { operator -> "\\" + operator.representation }
            .joinToString(separator = "|") +
            ")"

    fun evaluate(expression: String): BigDecimal {
        val tokens = splitToTokens(expression)
        val postfixNotationExpression = postfixNotationTransformer.transform(tokens)

        return BigDecimal(postfixNotationCalculator.calculate(postfixNotationExpression))
    }

    private fun splitToTokens(expression: String): List<String> {
        return expression
                .replace(regex = Regex(OPERATORS), replacement = " $1 ")
                .split(regex = Regex("\\s+"))
    }

}