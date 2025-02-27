package org.leetcode;

import java.util.ArrayList;
import java.util.Map;

public class ReverseVowels {

	/**
	 * 345. Reverse Vowels of a String
	 * Given a string s, reverse only all the vowels in the string and return it.
	 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

	 * Example 1:
	 * Input: s = "IceCreAm"
	 * Output: "AceCreIm"
	 * Explanation:
	 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

	 * Example 2:
	 * Input: s = "leetcode"
	 * Output: "leotcede"

	 * Constraints:
	 * 1 <= s.length <= 3 * 105
	 * s consist of printable ASCII characters.
	 */

	public static String reverseVowels(String s) {
		Map<Character, String> newMap = Map.of('a', "a", 'e', "e", 'i', "i", 'o', "o", 'u', "u",
			'A', "A", 'E', "E", 'I', "I", 'O', "O", 'U', "U");
		ArrayList<Character> newArray = new ArrayList<>();

		for (int i=0; i<s.length(); i++) {
			if (newMap.containsKey(s.charAt(i))) {
				newArray.add(s.charAt(i));
			}
		}

		int j = newArray.size() - 1;

		for (int i=0; i<s.length(); i++) {
			if (newMap.containsKey(s.charAt(i))) {
				s.replace(s.charAt(i), newArray.get(j));
				j--;
			}
		}

		return s;
	}

	public static String reverseVowels2(String s) {
		// 일단 입력받은 문자열을 char 배열로 전환
		char[] word = s.toCharArray();
		
		// 시작 포인터
		int start = 0;
		// 끝 포인터
		int end = s.length() - 1;
		
		// 모음 대소문자 문자열
		String vowels = "aeiouAEIOU";

		// 시작 포인터가 종료 포인터보다 작을 때 까지
		while (start < end) {
			// Move start pointer until it points to a vowel
			while (start < end && vowels.indexOf(word[start]) == -1) {
				start++;
			}

			// Move end pointer until it points to a vowel
			while (start < end && vowels.indexOf(word[end]) == -1) {
				end--;
			}

			// Swap the vowels
			char temp = word[start];
			word[start] = word[end];
			word[end] = temp;

			// Move the pointers towards each other
			start++;
			end--;
		}

		String answer = new String(word);
		return answer;
	}

	public static String reverseVowels3(String s) {
		String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		
		int len = s.length();
		
		int start = 0;
		int end = s.length() - 1;
		
		while (start < end) {
			
			// 각 start와 end를 while문을 돌리며 증가 감소 시켜 모음이 나올 때 까지 돌림
			while (start < end && !vowels.contains(Character.toString(chars[start]))) {
				start++;
			}
			while (start < end && !vowels.contains(Character.toString(chars[end]))) {
				end--;
			}

			// 각각 모음이 있는 인덱스에 도달했다면 swap
			char tmp = chars[end];
			chars[end] = chars[start];
			chars[start] = tmp;

			// 이후 각 한 칸씩 증감시켜 다음 반복문 동작
			start++;
			end--;
		}

		// 문자 배열을 문자열로 치환해 반환
		return new String(chars);
	}
	
	public static void main(String[] args) {
		System.out.println(reverseVowels2("IceCreAm"));
		System.out.println(reverseVowels3("leetcode"));
	}

}
