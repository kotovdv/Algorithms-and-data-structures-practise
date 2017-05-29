package com.kotovdv.algorithms.various.tree.traversal.concrete

import com.kotovdv.algorithms.various.tree.TreeNode
import com.kotovdv.algorithms.various.tree.traversal.Traversal
import com.kotovdv.algorithms.various.tree.traversal.TraversalAction
import java.util.*

/**
 * Pre order tree traversal implementation (Center - Left - Right)

 * @author Dmitriy Kotov
 */
class PreOrderTraversal : Traversal {

    override fun <T> traverse(rootNode: TreeNode<T>, traversalAction: TraversalAction<T>) {
        val stack: Deque<TreeNode<T>> = LinkedList<TreeNode<T>>()

        stack.push(rootNode)
        while (!stack.isEmpty()) {
            val currentNode = stack.pop()
            traversalAction.apply(currentNode)

            val rightNode = currentNode.rightNode
            if (rightNode != null) {
                stack.push(rightNode)
            }

            val leftNode = currentNode.leftNode
            if (leftNode != null) {
                stack.push(leftNode)
            }
        }
    }
}