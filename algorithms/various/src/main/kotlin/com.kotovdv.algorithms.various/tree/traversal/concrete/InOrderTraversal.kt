package com.kotovdv.algorithms.various.tree.traversal.concrete

import com.kotovdv.algorithms.various.tree.TreeNode
import com.kotovdv.algorithms.various.tree.traversal.Traversal
import com.kotovdv.algorithms.various.tree.traversal.TraversalAction
import java.util.*

/**
 * In order tree traversal implementation (Left - Center - Right)
 *
 *
 * @author Dmitriy Kotov
 */
class InOrderTraversal : Traversal {

    override fun <T> traverse(rootNode: TreeNode<T>, traversalAction: TraversalAction<T>) {
        val stack: Deque<TreeNode<T>> = LinkedList<TreeNode<T>>()

        pushLeftElements(rootNode, stack)

        while (!stack.isEmpty()) {
            val poppedElement = stack.pop()
            traversalAction.apply(poppedElement)

            if (poppedElement.rightNode != null) {
                pushLeftElements(poppedElement.rightNode, stack)
            }
        }
    }

    private fun <T> pushLeftElements(startingElement: TreeNode<T>?, stack: Deque<TreeNode<T>>) {
        var current = startingElement
        while (current != null) {
            stack.push(current)
            current = current.leftNode
        }
    }
}