package subsequent_thee_length_palindrome

import java.util.*


fun countPalindromicSubsequence(s: String): Int {
    val palSet = mutableSetOf<String>()
    var checkedMask = 0
    for (i in 0..s.length - 1) {
        val l = s[i]
        if (checkedMask and (1 shl (l.code - 'a'.code)) == 0) {
            var j = s.length - 1;
            var r = s[j]
            while (r != l) {
                j--
                r = s[j]
            }
            if (j != i) {
                for (k in i + 1..j - 1) {
                    palSet.add(String(charArrayOf(l, s[k], r)))
                }
            }
        }
        checkedMask = checkedMask.or(1 shl (l.code - 'a'.code))
    }
    return palSet.size
}

fun countPalindromicSubsequenceLeetCodeA1(s: String): Int {
    val letters: MutableSet<Char?> = mutableSetOf()
    for (c in s.toCharArray()) {
        letters.add(c)
    }

    var ans = 0
    for (letter in letters) {
        var i = -1
        var j = 0

        for (k in 0..<s.length) {
            if (s[k] == letter) {
                if (i == -1) {
                    i = k
                }
                j = k
            }
        }

        val between: MutableSet<Char?> = mutableSetOf()
        for (k in i + 1..<j) {
            between.add(s[k])
        }
        ans += between.size
    }

    return ans
}

fun countPalindromicSubsequenceLeetCodeA2(s: String): Int {
    val first = IntArray(26)
    val last = IntArray(26)
    Arrays.fill(first, -1)

    for (i in 0..<s.length) {
        val curr = s[i].code - 'a'.code
        if (first[curr] == -1) {
            first[curr] = i
        }

        last[curr] = i
    }

    var ans = 0
    for (i in 0..25) {
        if (first[i] == -1) {
            continue
        }

        val between: MutableSet<Char?> = mutableSetOf()
        for (j in first[i] + 1..<last[i]) {
            between.add(s[j])
        }

        ans += between.size
    }

    return ans
}
