package yacoder.dictionary

class DictionaryReader(private val size: Int) {
    fun readDictionary(): Array<out String> {
        return Array(size) { readln() }
    }
}