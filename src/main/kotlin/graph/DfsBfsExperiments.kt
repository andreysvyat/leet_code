package graph

import java.util.*

class Node(
    val value: Int,
    val leafs: List<Node>
){
    override fun toString(): String {
        return value.toString()
    }
}


fun dfs(root: Node): List<Int> {
    val flatten = mutableListOf(root.value)
    for (node in root.leafs) {
        flatten.addAll(dfs(node))
    }
    return flatten
}

fun dfsStack(root: Node): List<Int> {
    val flatten = mutableListOf<Int>()
    val stack = Stack<Node>()
    stack.push(root)
    while (stack.isNotEmpty()){
        val current = stack.pop()
        for (node in current.leafs.reversed()){
            stack.push(node)
        }
        flatten.add(current.value)
    }
    return flatten
}

fun bfs(root: Node): List<Int> {
    val queue = mutableListOf(root)
    val result = mutableListOf<Int>()
    while (!queue.isEmpty()){
        val current = queue.removeFirst()
        result.add(current.value)
        queue.addAll(current.leafs)
    }
    return result
}