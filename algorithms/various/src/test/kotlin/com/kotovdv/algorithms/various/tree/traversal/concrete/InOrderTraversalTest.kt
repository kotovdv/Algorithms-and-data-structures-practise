package com.kotovdv.algorithms.various.tree.traversal.concrete

import com.kotovdv.algorithms.various.tree.traversal.MemorizingTraversalAction
import com.kotovdv.algorithms.various.tree.traversal.TraversalTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * @author Dmitriy Kotov
 */
class InOrderTraversalTest : TraversalTest() {

    @Test
    fun testTraversal() {
        val rootNode = firstScenario()
        val traversalAction = MemorizingTraversalAction<Int>()
        InOrderTraversal().traverse(rootNode, traversalAction)

        assertThat(traversalAction.elements).isEqualTo(listOf(1, 2, 3, 4, 5, 6, 7))
    }
}