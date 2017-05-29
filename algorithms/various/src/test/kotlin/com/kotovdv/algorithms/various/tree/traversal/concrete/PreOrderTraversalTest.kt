package com.kotovdv.algorithms.various.tree.traversal.concrete

import com.kotovdv.algorithms.various.tree.traversal.MemorizingTraversalAction
import com.kotovdv.algorithms.various.tree.traversal.TraversalTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * @author Dmitriy Kotov
 */
class PreOrderTraversalTest : TraversalTest() {

    @Test
    fun testTraversal() {
        val rootNode = firstScenario()
        val traversalAction = MemorizingTraversalAction<Int>()
        PreOrderTraversal().traverse(rootNode, traversalAction)

        assertThat(traversalAction.elements).isEqualTo(listOf(4, 2, 1, 3, 6, 5, 7))
    }
}