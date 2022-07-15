package guess_num

import kotlin.random.Random

abstract class GuessGame() {
	private var pick = -1

	/**
	 * The API guess is defined in the parent class.
	 * @param  num   your guess
	 * @return        -1 if num > pick
	 *			       1 if num < pick
	 *                 0 if num == pick
	 * fun guess(num:Int):Int {}
	 */
	fun guess(num: Int): Int = pick.compareTo(num)

	open fun guessNumber(n: Int): Int {
		pick = Random.Default.nextInt(1, n)
		return -1
	}
}


class Solution : GuessGame() {
	override fun guessNumber(n: Int): Int {
		super.guessNumber(n)
		var current = n / 2
		var min = 1
		var max = n
		while (guess(current) != 0) {
			if (guess(current) > 0) {
				min = current
				current += countMedian(min, max)
			} else {
				max = current
				current -= countMedian(min, max)
			}
		}
		return current
	}

	private fun countMedian(min: Int, max: Int): Int {
		return if ((max - min) % 2 == 0)
			(max - min) / 2
		else
			(max - min) / 2 + 1
	}
}

/**
 * pick = 6
 * n = 10
 *
 * 5 == 6 f
 * 5 > 6 f
 *
 */
fun main() {
	val sol = Solution()
	for (i in 10..10000 step 10) {
		for (j in 0..10)
			if (sol.guess(sol.guessNumber(i)) != 0)
				print("fail")
	}
}