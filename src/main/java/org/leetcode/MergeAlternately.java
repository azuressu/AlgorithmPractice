package org.leetcode;

public class MergeAlternately {

    /**
     * 1768. Merge Strings Alternately
     * Hint
     * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
     * If a string is longer than the other, append the additional letters onto the end of the merged string.
     *
     * Example 1:
     * Input: word1 = "abc", word2 = "pqr"
     * Output: "apbqcr"
     * Explanation: The merged string will be merged as so:
     * word1:  a   b   c
     * word2:    p   q   r
     * merged: a p b q c r
     *
     * Example 2:
     * Input: word1 = "ab", word2 = "pqrs"
     * Output: "apbqrs"
     * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
     * word1:  a   b
     * word2:    p   q   r   s
     * merged: a p b q   r   s
     *
     * Example 3:
     * Input: word1 = "abcd", word2 = "pq"
     * Output: "apbqcd"
     * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
     * word1:  a   b   c   d
     * word2:    p   q
     * merged: a p b q c   d
     *
     * Constraints:
         * 1 <= word1.length, word2.length <= 100
         * word1 and word2 consist of lowercase English letters.
     */

    // 내 풀이 방법
    public static String merge(String word1, String word2) {
        // 두 단어의 길이를 비교해서 길이를 저장
        int length = Math.min(word1.length(), word2.length());

        StringBuffer sb = new StringBuffer();

        for (int i=0; i<length; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (word1.length() > word2.length()) {
            sb.append(word1, length, word1.length());
        } else if (word2.length() > word1.length()) {
            sb.append(word2, length, word2.length());
        }

        return sb.toString();
    }
    
    // 다른 방법
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String result1 = merge("abc", "pqr");
        System.out.println("abc + pqr = " + result1);

        String result2 = merge("ab", "pqrs");
        System.out.println("ab + pqrs = " + result2);

        String result3 = merge("abcd", "pq");
        System.out.println("abcd + pq = " + result3);
    }
}
