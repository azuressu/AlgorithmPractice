package org.leetcode;

public class ReverseWords {

	/**
	 * 151. Reverse Words in a String
	 * Given an input string s, reverse the order of the words.
	 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
	 * Return a string of the words in reverse order concatenated by a single space.
	 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

	 * Example 1:
	 * Input: s = "the sky is blue"
	 * Output: "blue is sky the"

	 * Example 2:
	 * Input: s = "  hello world  "
	 * Output: "world hello"
	 * Explanation: Your reversed string should not contain leading or trailing spaces.

	 * Example 3:
	 * Input: s = "a good   example"
	 * Output: "example good a"
	 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

	 * Constraints:
	 * 1 <= s.length <= 104
	 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
	 * There is at least one word in s.
	 */

	public static String reverseWords(String s) {
		String[] stringArray = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i=stringArray.length-1; i>=0; i--) {
			String newStr = stringArray[i].replace(" ", "");
			if (newStr.equals("")) continue;

			if (i != 0 || i != stringArray.length-1) {
				sb.append(" ").append(newStr);
			} else {
				sb.append(newStr);
			}
		}

		return sb.toString();
	}

	public static String reverseWords2(String s) {
		String[] words = s.split("\\s+");
		StringBuilder res = new StringBuilder();

		for (int i = words.length - 1; i >= 0; i--) {
			res.append(words[i]);
			if (i != 0) {
				res.append(" ");
			}
		}

		// trim() : 마지막 문자의 공백을 제거하는 메서드 ..!!
		return res.toString().trim();
	}

	public static String reverseWords3(String s) {
		String[] words = s.split(" ");
		int left = 0;
		int right = words.length - 1;

		while (left < right) {
			String temp = words[left];
			words[left] = words[right];
			words[right] = temp;
			left++;
			right--;
		}

		StringBuilder result = new StringBuilder();
		for (String word : words) {
			if (!word.isEmpty()) {
				if (result.length() > 0) {
					result.append(" ");
				}
				result.append(word);
			}
		}

		return result.toString();
	}

	public static String reverseWords4(String s) {
		StringBuilder sb = new StringBuilder();
		// 포인터 개념 적용
		int end = s.length() - 1;
		int start = end;

		// start가 0보다 큰 경우 (오른쪽에서 왼쪽으로 계속 감소함)
		while( start >= 0 ){
			// 공백을 만나면 둘 다 감소
			while( start >= 0 && s.charAt(end) == ' '){
				end--;
				start--;
			}
			// 공백이 아니면 start 값만 감소
			while( start >= 0 && s.charAt(start) != ' ')
				start--;

			// start 값이 -1 이라면
			if (start == -1) {
				sb.append(s.substring(start+1,end+1));
			} else {
				sb.append(s.substring(start+1,end+1));
				sb.append(" ");
			}

			start--;
			end = start;
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords2("  hello world  "));
	}

}
