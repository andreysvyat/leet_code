package yacoder.dictionary


fun main() {
    val sentence = readln()
    val dictionarySize = readln().toInt()
    val dictionary = DictionaryReader(dictionarySize).readDictionary()
    println(SplitterByDictionary(sentence, dictionary).getSentenceWithSpaces())
}