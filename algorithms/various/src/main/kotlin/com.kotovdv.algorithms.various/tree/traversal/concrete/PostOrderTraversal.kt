package com.kotovdv.algorithms.various.tree.traversal.concrete

import com.kotovdv.algorithms.various.tree.TreeNode
import com.kotovdv.algorithms.various.tree.traversal.Traversal
import com.kotovdv.algorithms.various.tree.traversal.TraversalAction
import java.util.*

/**
 * Post order tree traversal implementation (Left Right Center)
 *
 * @author Dmitriy Kotov
 */
class PostOrderTraversal : Traversal {

    override fun <T> traverse(rootNode: TreeNode<T>, traversalAction: TraversalAction<T>) {
        val stack: Deque<TreeNode<T>> = LinkedList<TreeNode<T>>()

        while (!stack.isEmpty()) {
            TODO("Finish implementation")
        }
    }
}