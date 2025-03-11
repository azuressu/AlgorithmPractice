package org.leetcode;

public class IsSubsequence {

	/**
	 * 392. Is Subsequence
	 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
	 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
	 * of the characters without disturbing the relative positions of the remaining characters.
	 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

	 * Example 1:
	 * Input: s = "abc", t = "ahbgdc"
	 * Output: true

	 * Example 2:
	 * Input: s = "axc", t = "ahbgdc"
	 * Output: false

	 * Constraints:
	 * 0 <= s.length <= 100
	 * 0 <= t.length <= 104
	 * s and t consist only of lowercase English letters.

	 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
	 * and you want to check one by one to see if t has its subsequence.
	 * In this scenario, how would you change your code?
	 */
	// 오답 코드
	public static boolean isSubsequence(String s, String t) {
		int s1 = 0;
		int t1 = 0;

		while (s1 < s.length() && t1 < t.length()) {
			if (s.charAt(s1) == t.charAt(t1)) {
				s1 ++;
			}
			t1 ++;
		}

		// return s1 == s.length() ? true : false;
		return s1 == s.length();
	}

	// 정답 코드
	public static boolean isSubsequence2(String s, String t) {
		int s1 = 0;
		int t1 = 0;

		while (s1 < s.length() && t1 < t.length()) {
			if (s.charAt(s1) == t.charAt(t1)) {
				s1 ++;
			}
			t1 ++;
		}

		return s1 == s.length();
	}

	// 정답 코드2
	public static boolean isSubsequence3(String s, String t) {
		if (s.isEmpty()) return true;

		int s1 = 0;
		int t1 = 0;

		while (t1 < t.length()) {

			if (t.charAt(t1) == s.charAt(s1)) {
				s1++;
				if (s1 == s.length()) return true;
			}

			t1++;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("axc", "ahbgdc"));
	}
}
