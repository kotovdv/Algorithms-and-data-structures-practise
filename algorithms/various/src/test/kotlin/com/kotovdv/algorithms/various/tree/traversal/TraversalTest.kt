package com.kotovdv.algorithms.various.tree.traversal

import com.kotovdv.algorithms.various.tree.TreeNode

/**
 * @author Dmitriy Kotov
 */
abstract class TraversalTest {

    protected fun firstScenario(): TreeNode<Int> {
        val rootNode = TreeNode(4)
        val leftRootNode = TreeNode(2, TreeNode(1), TreeNode(3))
        val rightRootNode = TreeNode(6, TreeNode(5), TreeNode(7))
        rootNode.leftNode = leftRootNode
        rootNode.rightNode = rightRootNode

        return rootNode
    }
}