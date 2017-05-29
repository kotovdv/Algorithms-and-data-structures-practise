package com.kotovdv.algorithms.various.tree.traversal

import com.kotovdv.algorithms.various.tree.TreeNode
import java.util.*

/**
 * @author Dmitriy Kotov
 */
class MemorizingTraversalAction<T> : TraversalAction<T> {

    val elements = LinkedList<T>()

    override fun apply(argument: TreeNode<T>) {
        elements.add(argument.value)
    }
}