package com.kotovdv.algorithms.various.tree.traversal

import com.kotovdv.algorithms.various.tree.TreeNode

/**
 * @author Dmitriy Kotov
 */
@FunctionalInterface
interface TraversalAction<T> {
    fun apply(argument: TreeNode<T>)
}