package utils

import kotlin.random.Random

fun randomString(n: Int, alphabet: String, random: Random = Random.Default): String {
    require(n >= 0) { "n must be non-negative" }
    require(alphabet.isNotEmpty()) { "alphabet must not be empty" }
    return buildString(n) {
        repeat(n) { append(alphabet[random.nextInt(alphabet.length)]) }
    }
}
