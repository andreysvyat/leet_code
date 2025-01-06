package shift_letters

fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
    val shiftsArray = prepareShiftsArray(s.length, shifts)
    return shiftsArray.mapIndexed { i, shift -> doRingShift(shift, s[i]) }.joinToString(separator = "")
}

fun doRingShift(shift: Int, char: Char): Char {
    val normalized = char.code - 'a'.code
    val normalizedShift = ((normalized + shift) % 26)
    if(normalizedShift >= 0){
        return (normalizedShift + 'a'.code).toChar()
    } else {
        return (26 + normalizedShift + 'a'.code).toChar()
    }
}

fun prepareShiftsArray(sLen: Int, shifts: Array<IntArray>): IntArray {
    val shiftArray = IntArray(sLen)
    for (shift in shifts) {
        for (i in shift[0]..shift[1]) {
            if (shift[2] == 1) {
                shiftArray[i]++
            } else if (shift[2] == 0) {
                shiftArray[i]--
            }
        }
    }
    return shiftArray
}