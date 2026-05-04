package tree.btlot

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(v: Int, l: TreeNode?, r: TreeNode?) : this(v) {
        left = l
        right = r
    }

    override fun toString(): String = buildString { append(this@TreeNode, "", true) }

    private fun StringBuilder.append(node: TreeNode?, prefix: String, isTail: Boolean) {
        append(prefix)
        append(if (isTail) "└── " else "├── ")
        if (node == null) {
            append('\n')
            return
        }
        append(node.`val`).append('\n')
        if (node.left == null && node.right == null) return
        val childPrefix = prefix + if (isTail) "    " else "│   "
        append(node.left, childPrefix, false)
        append(node.right, childPrefix, true)
    }
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        return BinaryTreeLevelTraversal(root).levelOrder()
    }
}
