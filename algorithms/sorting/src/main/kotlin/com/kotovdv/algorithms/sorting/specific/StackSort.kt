package com.kotovdv.algorithms.sorting.specific

import java.util.*

/**
 * Sorts incoming stack structure without using any additional data structures
 */
class StackSort {

    fun sort(stack: Deque<Int>) {
        while (bubbleUpOneElement(stack)) {
        }
    }

    /**
     * This is a variation of bubble sort algorithm applied to stack data structure
     * Attempts to bring biggest element down the stack
     *
     * @return true if at least one swap was performed during the whole call tree/false otherwise
     */
    private fun bubbleUpOneElement(stack: Deque<Int>): Boolean {
        if (stack.isEmpty()) {
            return false
        }

        val poppedElement = stack.pop()
        if (!stack.isEmpty() && stack.peek() < poppedElement) {
            val newlyPoppedElem = stack.pop()
            stack.push(poppedElement)
            bubbleUpOneElement(stack)
            stack.push(newlyPoppedElem)

            return true
        } else {
            val hadSwaps = bubbleUpOneElement(stack)
            stack.push(poppedElement)

            return hadSwaps
        }
    }
}