package tree.btlot

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeLevelTraversalTest {
    @Test
    fun levelOrder3_9_20_15_7() {
        val root = TreeNode(3, l = TreeNode(9), r = TreeNode(20, l = TreeNode(15), r = TreeNode(7)))
        val expected = listOf(listOf(3), listOf(9, 20), listOf(15, 7))
        val worker = traversal(root)
        val actual = worker.levelOrder()
        assertEquals(expected, actual)
    }

    @Test
    fun levelOrder1_2_3_4_5() {
        val root = TreeNode(1, l = TreeNode(2, TreeNode(4), null), r = TreeNode(3, l = TreeNode(5), r = null))
        val expected = listOf(listOf(1), listOf(2, 3), listOf(4, 5))
        val worker = traversal(root)
        val actual = worker.levelOrder()
        assertEquals(expected, actual)
    }

    @Test
    fun levelOrder5_4_3_3_1() {
        val root = TreeNode(5, TreeNode(4, TreeNode(3, TreeNode(2, TreeNode(1), null), null), null), null)
        val expected = listOf(listOf(5),listOf(4),listOf(3),listOf(2),listOf(1))
        val worker = traversal(root)
        val actual = worker.levelOrder()
        assertEquals(expected, actual)
    }

    @Test
    fun levelOrder1() {
        val root = TreeNode(1)
        val expected = listOf(listOf(1))
        val worker = traversal(root)
        val actual = worker.levelOrder()
        assertEquals(expected, actual)
    }

    @Test
    fun levelOrderFullThreeLevels() {
        val root = TreeNode(
            1,
            l = TreeNode(2, l = TreeNode(4), r = TreeNode(5)),
            r = TreeNode(3, l = TreeNode(6), r = TreeNode(7))
        )
        val expected = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6, 7))
        val worker = traversal(root)
        val actual = worker.levelOrder()
        assertEquals(expected, actual)
    }

    @Test
    fun printTree() {
        val root = TreeNode(
            1,
            l = TreeNode(2, l = TreeNode(4), r = TreeNode(5)),
            r = TreeNode(3, l = TreeNode(6), r = TreeNode(7))
        )
        println(root)
    }

    private fun traversal(root: TreeNode): BinaryTreeLevelTraversal = BinaryTreeLevelTraversal(root)

}