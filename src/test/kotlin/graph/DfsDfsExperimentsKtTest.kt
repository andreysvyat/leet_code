package graph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

val TREE = Node(
    0,
    listOf(
        Node(
            1, listOf(
                Node(
                    4, listOf(
                        Node(13, listOf()),
                        Node(14, listOf()),
                        Node(15, listOf())
                    )
                ),
                Node(
                    5, listOf(
                        Node(16, listOf()),
                        Node(17, listOf()),
                        Node(18, listOf())
                    )
                ),
                Node(
                    6, listOf(
                        Node(19, listOf()),
                        Node(20, listOf()),
                        Node(21, listOf())
                    )
                )
            )
        ),
        Node(
            2, listOf(
                Node(
                    7, listOf(
                        Node(22, listOf()),
                        Node(23, listOf()),
                        Node(24, listOf())
                    )
                ),
                Node(
                    8, listOf(
                        Node(25, listOf()),
                        Node(26, listOf()),
                        Node(27, listOf())
                    )
                ),
                Node(
                    9, listOf(
                        Node(28, listOf()),
                        Node(29, listOf()),
                        Node(30, listOf())
                    )
                )
            )
        ),
        Node(
            3, listOf(
                Node(
                    10, listOf(
                        Node(31, listOf()),
                        Node(32, listOf()),
                        Node(33, listOf())
                    )
                ),
                Node(
                    11, listOf(
                        Node(34, listOf()),
                        Node(35, listOf()),
                        Node(36, listOf())
                    )
                ),
                Node(
                    12, listOf(
                        Node(37, listOf()),
                        Node(38, listOf()),
                        Node(39, listOf())
                    )
                )
            )
        )
    )
)

class DfsDfsExperimentsKtTest {
    @Test
    fun dfsTest() {
        val flatten = dfs(TREE)
        assertEquals(
            listOf(
                0, 1, 4, 13, 14,
                15, 5, 16, 17, 18,
                6, 19, 20, 21, 2,
                7, 22, 23, 24, 8,
                25, 26, 27, 9, 28,
                29, 30, 3, 10, 31,
                32, 33, 11, 34, 35,
                36, 12, 37, 38, 39
            ), flatten
        )
    }

    @Test
    fun dfsOnStackTest() {
        val flatten = dfsStack(TREE)
        assertEquals(
            listOf(
                0, 1, 4, 13, 14,
                15, 5, 16, 17, 18,
                6, 19, 20, 21, 2,
                7, 22, 23, 24, 8,
                25, 26, 27, 9, 28,
                29, 30, 3, 10, 31,
                32, 33, 11, 34, 35,
                36, 12, 37, 38, 39
            ), flatten
        )
    }

    @Test
    fun bfsTest() {
        val flatten = bfs(TREE)
        assertEquals((0..39).toList(), flatten)
    }
}