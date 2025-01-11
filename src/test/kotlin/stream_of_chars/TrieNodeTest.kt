package stream_of_chars

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TrieNodeTest {

    @Test
    fun findByCharTest() {
        val root = TrieNode(0.toChar(), 'a', 'b', 'c')
        assertEquals('b', root.findChildByValue('b')!!.char)
    }

    fun test(){
        val test = listOf("1", "2") + null
        assertEquals(listOf("1", "2"), test)
    }
}