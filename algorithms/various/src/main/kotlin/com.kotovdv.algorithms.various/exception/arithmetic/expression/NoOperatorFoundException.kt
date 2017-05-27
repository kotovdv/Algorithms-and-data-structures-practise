package com.kotovdv.algorithms.various.exception.arithmetic.expression

/**
 * @author Dmitriy Kotov
 */
class NoOperatorFoundException(operator: String) : ArithmeticExpressionEvaluationExpression("No operator found for $operator")