package string.lswrc

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        return LongestNoisySubstring(s).getLength()
    }
}