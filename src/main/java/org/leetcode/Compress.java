package org.leetcode;

public class Compress {

	/**
	 * 443. String Compression
	 * Given an array of characters chars, compress it using the following algorithm:
	 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
	 	* If the group's length is 1, append the character to s.
	 	* Otherwise, append the character followed by the group's length.
	 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
	 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
	 * After you are done modifying the input array, return the new length of the array.
	 * You must write an algorithm that uses only constant extra space.

	 * Example 1:
	 * Input: chars = ["a","a","b","b","c","c","c"]
	 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
	 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

	 * Example 2:
	 * Input: chars = ["a"]
	 * Output: Return 1, and the first character of the input array should be: ["a"]
	 * Explanation: The only group is "a", which remains uncompressed since it's a single character.

	 * Example 3:
	 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
	 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
	 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

	 * Constraints:
	 * 1 <= chars.length <= 2000
	 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
	 * */

	// 문제 이해부터 어려워서 답을 보고 이해하는 것으로
	public static int compress(char[] chars) {
		// 입력받은 character 배열의 길이 저장
		int n = chars.length;

		// 인덱스를 0으로 초기화
		int idx = 0;

		// character 배열 반목문 돌기
		for (int i = 0; i < n; i++) {
			// character 배열의 원소
			char ch = chars[i];
			// character 원소가 반복될 횟수
			int count = 0;

			// 현재 원소부터 배열의 끝까지 반복문 돌기
			// 단, 현재 원소와 배열의 원소가 같을 때 까지만
			// 바깥 반복문에서 사용하는 i 사용
			while (i < n && chars[i] == ch) {
				// 반복 횟수 증가
				count ++;
				// 인덱스 번호 증가 (연속되는 문자열 건너뛰기)
				i ++;
			}

			// 문자가 한 개만 있으면 그대로 저장
			if (count == 1) {
				chars[idx++] = ch;
			// 문자가 여러 개라면, 문자를 먼저 저장
			} else {
				chars[idx++] = ch;
				// 개수를 문자열로 변환하여 하나씩 저장
				for (char digit : Integer.toString(count).toCharArray()) {
					chars[idx++] = digit;
				}
			}
			// while 문에서 i가 한 번 더 증가하므로, i--를 해줘서 for 문에서 i++ 될 때 제대로 된 위치로 이동
			i--;
		}
		// 압축된 배열의 새로운 길이 반환
		return idx;
	}

	public static int compress2(char[] chars) {
		// keep track of current position in compressed array
		// 현재 배열의 위치(인덱스 번호)
		int ans = 0; 

		// i pointer로 반복문 돌리기
		for (int i = 0; i < chars.length;) {
			// 현재 문자
			final char letter = chars[i];
			// 문자의 반복 횟수
			int count = 0;

			// 입력받은 문자 배열의 반복문 돌리기
			while (i < chars.length && chars[i] == letter) {
				++ count;
				++ i;
			}

			// 문자를 문자 배열에 저장
			chars[ans++] = letter;

			// count가 1보다 크다면
			if (count > 1) {
				for (final char c : String.valueOf(count).toCharArray()) {
					chars[ans++] = c;
				}
			}
		}

		// return length of compressed array
		return ans;
	}

	public static int compress3(char[] chars) {
		int n = chars.length;
		int index = 0;

		for (int i = 0; i < n; i++) {
			char ch = chars[i];
			int count = 0;
			while (i < n && chars[i] == ch) {
				count ++;
				i ++;
			}

			chars[index++] = ch;

			if (count > 1) {
				for (char digit : Integer.toString(count).toCharArray()) {
					chars[index++] = digit;
				}
			}

			i--;
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(compress3(new char[]{'a','a','b','b','c','c','c'}));
	}
}
