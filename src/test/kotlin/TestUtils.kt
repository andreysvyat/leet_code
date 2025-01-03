fun arrayAssertionMessage(expect: IntArray, actual: IntArray): String {
    return "\n${actual.contentToString()} but expected\n${expect.contentToString()}\n"
}