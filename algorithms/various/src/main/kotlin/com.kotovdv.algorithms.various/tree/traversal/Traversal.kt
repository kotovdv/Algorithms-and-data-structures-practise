package com.kotovdv.algorithms.various.tree.traversal

import com.kotovdv.algorithms.various.tree.TreeNode

/**
 * @author Dmitriy Kotov
 */
interface Traversal {
    fun <T> traverse(rootNode: TreeNode<T>, traversalAction: TraversalAction<T>)
}