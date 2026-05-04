package tree.btlot

import java.util.*

class BinaryTreeLevelTraversal(
    private val root: TreeNode
) {
    fun levelOrder(): List<List<Int>> {
        val queue = LinkedList<TreeNodeWithDepth>()
        queue.offer(TreeNodeWithDepth(0, root))
        val result = mutableListOf<MutableList<Int>>()
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.node.left != null) {
                queue.offer(TreeNodeWithDepth(node.depth + 1, node.node.left!!))
            }
            if (node.node.right != null) {
                queue.offer(TreeNodeWithDepth(node.depth + 1, node.node.right!!))
            }
            if (node.depth >= result.size) {
                result.add(mutableListOf())
            }
            result[node.depth].add(node.node.`val`)
        }
        return result
    }
}

data class TreeNodeWithDepth(val depth: Int, val node: TreeNode)

fun exp2(rate: Int): Int {
    if (rate < 0) {
        throw IllegalArgumentException("rate must be greater than zero.")
    }
    return 1 shl rate
}


fun mapFlatToLeveledTree(
    flat: List<Int?>
): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    for (i in flat.indices) {
        val element = flat[i]
        if (i == exp2(result.size) - 1) {
            result.add(mutableListOf())
        }
        if (element != null) {
            result.last().add(element)
        }
    }
    return result.filter { it.isNotEmpty() }
}